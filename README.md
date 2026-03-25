# ICS 372 – Grocery Management System (OOP Project)

## Overview
The Grocery Management System is a Java-based application designed to demonstrate core Object-Oriented Programming (OOP) concepts. This project models real-world interactions between products, customers, inventory, and purchases using well-structured classes and relationships.

The system allows users to browse products, manage a shopping cart, and complete purchases while maintaining inventory consistency.

---

## Project Goals
This project was developed for ICS 372 (Object-Oriented Programming) with the goal of clearly demonstrating:

- Encapsulation  
- Abstraction  
- Inheritance  
- Polymorphism  
- Interfaces  
- Composition  
- Method Overriding  
- Method Overloading  
- Use of Collections (ArrayList)  
- Meaningful object interaction  

---

## System Architecture

### Product Hierarchy
- Product (abstract base class)  
- PerishableProduct  
- HouseholdProduct  

### User Hierarchy
- Person  
- Member  

### Core Components
- ShoppingCart  
- CartItem  
- Inventory  
- Purchase  
- GroceryStoreSystem  
- Main (menu-driven interface)  

---

## OOP Concepts Demonstrated

### Encapsulation
All classes use private fields with controlled access through getters and setters to ensure data integrity.

### Abstraction
The Product class is abstract and defines shared structure and behavior for all product types while requiring subclasses to implement specific details.

### Inheritance
Specialized product types extend the Product class. Member extends Person to demonstrate reuse of common properties.

### Polymorphism
Collections such as ArrayList<Product> store multiple product types. Overridden methods are invoked based on the actual object type at runtime.

### Interfaces
The Discountable interface defines behavior for applying discounts, allowing flexible implementation across different classes.

### Composition
- ShoppingCart contains CartItem objects  
- CartItem contains a Product  
- Inventory manages a collection of Product objects  
- Purchase contains purchased CartItem objects  

### Method Overriding
Subclasses override methods such as product detail display and pricing behavior.

### Method Overloading
Methods such as adding items to the cart support multiple parameter variations (e.g., with or without quantity).

---

## Technologies Used
- Java  
- Eclipse IDE  
- Java Collections Framework (ArrayList)  

---

## Project Structure


src/
├── model/
├── service/
├── interfaces/
└── app/


---

## How to Run
1. Open the project in Eclipse  
2. Navigate to the Main class in the app package  
3. Run the application  
4. Follow the menu prompts in the console  

---

## Future Enhancements
- Persistent storage (file or database)  
- Improved input validation and error handling  
- Enhanced user interface  
- Additional product types and discount strategies  

---

## Author
Avery Jacobson