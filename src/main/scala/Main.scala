import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.ml.feature.{StringIndexer, VectorAssembler}
import org.apache.spark.sql.functions.col
object  Main  {

    def main(args: Array[String]): Unit = {
        val spark = SparkSession.builder().appName("Main").master("local[*]").getOrCreate()
        val df: DataFrame = spark.read.option("header", "true").csv("src/main/scala/student_data.csv")

        df.printSchema()
        val numericColumns = df.columns
        val convertedDF = numericColumns.foldLeft(df) { (tempDF, colName) =>
            tempDF.withColumn(colName, col(colName).cast("double"))
        }

        val featureColumns = convertedDF.columns.filter(_ != "GradeClass")

        val assembler = new VectorAssembler()
          .setInputCols(featureColumns)
          .setOutputCol("features")

        val assembledData = assembler.transform(convertedDF)
          .select("features", "GradeClass")

        val Array(trainingData, testData) = assembledData.randomSplit(Array(0.7, 0.3))

        val dt = new DecisionTreeClassifier()
          .setLabelCol("GradeClass")
          .setFeaturesCol("features")
          .setMaxBins(32)
          .setMaxDepth(5)

        val model = dt.fit(trainingData)

        val predictions = model.transform(testData)

        val evaluator = new MulticlassClassificationEvaluator()
          .setLabelCol("GradeClass")
          .setPredictionCol("prediction")
          .setMetricName("accuracy")

        val accuracy = evaluator.evaluate(predictions)
        println(s"Test Accuracy = $accuracy")
        println(s"Learned classification tree model:\n ${model.toDebugString}")

        spark.stop()
    }
}