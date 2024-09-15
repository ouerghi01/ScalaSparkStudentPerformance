# StudentPerformancePredictor

## Project Overview

**StudentPerformancePredictor** is a data science project that uses Apache Spark with Scala to analyze and predict student performance. The goal is to build a predictive model that forecasts student grades based on various factors such as study time, absences, and extracurricular activities.

## Features

- **Data Processing:** Efficient handling and transformation of large datasets using Apache Spark.
- **Machine Learning:** Implements a Decision Tree Classifier to predict student grades.
- **Scalability:** Utilizes Spark’s distributed computing capabilities for fast and scalable data processing.
- **Evaluation:** Assesses model performance with accuracy metrics.

## Technical Stack

- **Scala:** The primary programming language used for data transformation and machine learning model implementation.
- **Apache Spark:** Provides distributed data processing and machine learning capabilities.

## Getting Started

### Prerequisites

- **Apache Spark:** Ensure Spark is installed and properly configured on your system.
- **Scala:** Ensure Scala is installed on your system.
- **Build Tool:** Use `sbt` (Scala Build Tool) to manage dependencies and build the project.

### Installation

1. **Clone the Repository:**
    ```bash
    git clone https://github.com/ouerghi01/ScalaSparkStudentPerformance.git
    cd  ScalaSparkStudentPerformance
    ```

2. **Install Dependencies:**
    Ensure you have `sbt` installed. If not, follow the [sbt installation guide](https://www.scala-sbt.org/download.html).

    ```bash
    sbt update
    ```

3. **Run the Project:**
    To run the project, use `sbt`:
    ```bash
    sbt run
    ```

### Usage

1. **Prepare Data:**
    Ensure the dataset (`student_data.csv`) is available at the path specified in the code (`src/main/scala/student_data.csv`).

2. **Run Analysis:**
    Execute the main method to start data processing, model training, and evaluation.

## Project Structure

- `src/main/scala/Main.scala`: Contains the main implementation of the data processing and machine learning pipeline.
- `src/main/resources/student_data.csv`: Sample dataset for student performance.

## Evaluation

The model’s performance is evaluated based on accuracy metrics. The results are printed to the console.

## Contributing

Contributions are welcome! Please fork the repository, make your changes, and submit a pull request. Ensure that your code adheres to the project’s coding standards and includes appropriate tests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- Apache Spark for its powerful distributed computing capabilities.
- Scala for its concise and functional programming features.
- The dataset used for training and evaluation.

---

Feel free to customize this `README.md` to better fit the specifics of your project or add any additional sections as needed.
