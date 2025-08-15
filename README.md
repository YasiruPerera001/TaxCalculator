# Tax Calculator - Java Console Application

A Java-based **Command Line Interface (CLI)** application for calculating various types of taxes and leasing payments.  
This project was developed as part of a case study to simplify tax and leasing calculations through automation.

---

## 📌 **Features**

### 1. **Withholding Tax**
- **Rent Tax** – 10% charged for payments above Rs.100,000.
- **Bank Interest Tax** – 5% charged on annual bank interest.
- **Dividend Tax** – 14% charged for dividends above Rs.100,000.

### 2. **Payable Tax**
- Progressive tax calculation on monthly salary with different tax slabs.

### 3. **Income Tax**
- Progressive tax calculation on annual income with different tax slabs.

### 4. **Social Security Contribution Levy (SSCL) Tax**
- Step 1: Apply 2.5% Sale Tax to goods value.
- Step 2: Apply 15% VAT on the result.
- Total SSCL Tax = Sale Tax + VAT.

### 5. **Leasing Payments**
- **Monthly Installment Calculation** – Based on principal, interest, and term.
- **Search Leasing Category** – Monthly payments for 3, 4, and 5-year plans.
- **Find Leasing Amount** – Calculate total leasing amount possible for a given monthly payment.

---

## 🖥 **Example CLI Menu**

```text
=== TAX CALCULATOR ===
1. Withholding Tax
2. Payable Tax
3. Income Tax
4. SSCL Tax
5. Leasing Payment
Enter your choice:
```
## ⚙️ **How to Run**

### **Clone the Repository**
- git clone https://github.com/YasiruPerera001/TaxCalculator.git
- cd TaxCalculator

### **Compile the Java Files**
- javac src/*.java

### **Run the Program**
- java -cp src Main

## 🛠 **Requirements**

- Java 8 or later
- Command Line / Terminal

<img width="3778" height="2146" alt="Screenshot 2025-08-15 072432" src="https://github.com/user-attachments/assets/b13878d7-700c-4ef5-a94e-79eb2f70f54a" />
