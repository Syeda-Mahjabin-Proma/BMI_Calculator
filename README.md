# BMI Calculator Android App

## Overview

The **BMI Calculator** is a simple and user-friendly Android application designed to help users calculate their **Body Mass Index (BMI)** and understand their weight category. It also provides a healthy weight range suggestion based on age and height.

This App is:
  * Ideal for both **adults and children**
  * Inputs include **age, gender, height (feet + inches), and weight (kg)**
  * Outputs include **BMI score, health category, and weight range**

---

## 🔗 Download the App in Your Android Device: [BMI Calculator](https://drive.google.com/file/d/19OvKNK18csIdx0ncXNSo6LmoOSsryco4/view?usp=sharing)

---

## Features

### BMI Calculation

* Calculates BMI using metric units.
* Categorizes result as:

  * Underweight
  * Healthy
  * Overweight
  * Obese

### Gender & Age Consideration

* Select gender: Male or Female.
* Enter age:

  * **Age ≥ 18**: Displays BMI result and healthy weight range.
  * **Age < 18**: Suggests consulting a doctor for child-specific analysis.

### Healthy Weight Range

* Calculates minimum and maximum healthy weights based on height.
* Gives actionable insight into your ideal weight range.

### Input Validation

* Prompts the user if any required fields are left empty.
* Informs the user if gender is not selected.

### State Persistence

* Retains the last calculated result during screen rotation or activity recreation.

---

## UI Preview (XML Layout Highlights)

* Simple and clean **LinearLayout** design.
* Organized input fields for:

  * Age
  * Height (feet & inches)
  * Weight (kg)
* Radio buttons for gender selection.
* Result displayed with clear formatting.
* Responsive "CALCULATE" button.

---

## Sample Pictures:
![bmiCalc](https://github.com/user-attachments/assets/9f1db8cd-afcc-42ed-9452-072b2fb280b7)


---
## Installation & Run Locally

### Clone the Repository

```bash
git clone https://github.com/Syeda-Mahjabin-Proma/BMI_Calculator.git
```

### Open in Android Studio

1. Navigate to the BMI Calculator module inside the project.
2. Open with Android Studio.
3. Connect your Android device or use an emulator.
4. Click **Run** to install and test the app.

---

## Tech Stack

| Component    | Technology                  |
| ------------ | --------------------------- |
| Language     | Java                        |
| IDE          | Android Studio              |
| UI Design    | XML Layout                  |
| Image Assets | `bmi_img` in `res/drawable` |

---

## Contribution Guide

If you want to improve the app:
1. Fork the repository.
2. Create your feature branch:

   ```bash
   git checkout -b feature/new-feature
   ```
3. Commit your changes:

   ```bash
   git commit -m "Add new feature"
   ```
4. Push the branch:

   ```bash
   git push origin feature/new-feature
   ```
5. Open a Pull Request.

---

## License

This project is licensed under the [Apache-2.0 License](https://www.apache.org/licenses/).
