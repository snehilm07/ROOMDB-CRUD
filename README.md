# Student Info App

This is an Android Kotlin project that demonstrates the use of Room Database and Dagger Hilt to store and retrieve student information. The app allows users to create, update, delete, and fetch student records, which include their name, roll number, and scores in various subjects.

## Features

- **Create**: Add a new student record to the database.
- **Update**: Modify an existing student record.
- **Delete**: Remove a student record from the database.
- **Fetch**: Retrieve and display a student record.

## Data Model

The app uses the following data model:

- **User**: Represents a student with a name, roll number, and a list of subjects.
- **Subject**: Represents the scores in different subjects (e.g., English, Maths, Science).

## Tech Stack

- **Kotlin**: Programming language
- **Room Database**: Local data storage
- **Dagger Hilt**: Dependency injection
- **MVVM**: Architectural pattern

## Setup Instructions

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/your-username/student-info-app.git
    ```

2. **Open the Project**: Open the project in Android Studio.

3. **Build the Project**: Build the project to download all dependencies.

4. **Add Dependencies**:
    Ensure you have the following dependencies in your `build.gradle` files:

    - Project-level `build.gradle`:
        ```groovy
        buildscript {
            ext.hilt_version = "2.44"
            dependencies {
                classpath "com.google.dagger:hilt-android-gradle-plugin:$hilt_version"
            }
        }
        ```

    - App-level `build.gradle`:
        ```groovy
        plugins {
            id 'com.android.application'
            id 'kotlin-android'
            id 'kotlin-kapt'
            id 'dagger.hilt.android.plugin'
        }

        dependencies {
            implementation "com.google.dagger:hilt-android:$hilt_version"
            kapt "com.google.dagger:hilt-compiler:$hilt_version"

            // Room dependencies
            implementation "androidx.room:room-runtime:2.5.0"
            kapt "androidx.room:room-compiler:2.5.0"
            implementation "androidx.room:room-ktx:2.5.0"
        }
        ```

5. **Define `MyApplication` Class**:
    Create a `MyApplication` class and annotate it with `@HiltAndroidApp`.

6. **Register `MyApplication` in `AndroidManifest.xml`**:
    Update the `AndroidManifest.xml` file to use `MyApplication` as the application class.

    ```xml
    <application
        android:name=".MyApplication"
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
    ```

## Architecture

- **Database Layer**: Defines the `User` and `Subject` entities and a `SubjectConverter` for converting list of subjects.
- **DAO Interface**: Provides methods for database operations such as insert, update, delete, and fetch.
- **Repository**: Acts as a mediator between the ViewModel and the DAO, handling data operations.
- **ViewModel**: Manages UI-related data and handles interaction with the repository.

## UI

- **Activity**: Contains buttons for creating, updating, deleting, and fetching student records.
- **Layout**: Includes buttons for operations and a `TextView` to display user information.

## Screenshot

![image](https://github.com/user-attachments/assets/5bd6bd4d-d595-4462-8a41-000a7fc188ea)


---

Feel free to customize and expand upon this `README.md` to fit your project's specific details and requirements.
