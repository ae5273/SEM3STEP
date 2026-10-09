# Week 8 Practice - Concept Question Answers

### 1. How inheritance enables reuse plus specialization
A derived class automatically gains the fields and methods of its base class, so common
behavior is written once and reused. It can then override those methods (or add new ones) to
change or extend the behavior for its own needs.

*Business example:* A base `Employee` class holds `name` and a `calculatePay()` method. The
`FullTimeEmployee` and `Contractor` subclasses reuse the shared name logic but override
`calculatePay()` with their own salary rules, so payroll code can treat every employee the
same while each is paid correctly.

### 2. The "is-a" relationship
An "is-a" relationship means one class is a specialized kind of another (`Car` is a
`Vehicle`). Identifying it correctly matters because inheritance models specialization: if
the relationship is really a "has-a" or "uses-a" (composition), inheritance produces an
incorrect, rigid hierarchy that breaks encapsulation and misleads callers. Choosing
inheritance only for true "is-a" cases keeps the design semantically correct and extensible.

### 3. Method overriding
Method overriding lets a subclass provide its own implementation of a method already
declared in the base class, using the same signature.

*Business example:* A base `Employee` declares `calculateSalary()`. `Manager` overrides it to
add a bonus, while `Intern` overrides it to pay a stipend. When the payroll system calls
`calculateSalary()` through an `Employee` reference, the correct subclass version runs.

### 4. Runtime polymorphism (dynamic dispatch)
With a base-type reference pointing at a derived object, the JVM decides which method
implementation to run based on the object's *actual* runtime type, not the reference's
declared type. When the method is overridden, the version belonging to the real object is
invoked, which is why the correct specialized behavior executes automatically.

### 5. Polymorphic collections
A polymorphic collection stores elements typed as a common base class or interface while the
actual objects are instances of different derived types. For example, an array of `Shape`
can hold `Circle`, `Square`, and `Triangle` objects. Iterating with a base reference and
calling `area()` invokes each object's own implementation, so diverse but related objects are
processed uniformly, with less casting and less duplicated logic.

### 6. Polymorphism vs. repeated type-based conditionals
Repeated `if-else`/`switch` type checks centralize decision-making in the caller, so every
new type forces edits to that logic and existing code becomes fragile. Polymorphism pushes
the behavior into each type, so the caller just calls the common method. This is preferred
because it removes type-checking duplication, keeps behavior close to the data it belongs to,
follows the open/closed principle, and reduces the risk of bugs when types change.

### 7. Adding new derived types with minimal change
Because the processing logic depends only on the base type, introducing a new subtype does
not require modifying it.

*Example:* A payment system defines `Payment.process()` and a `PaymentProcessor` that loops
over `Payment` references. Adding a new `UPIPayment` class that overrides `process()` is
enough; the processor keeps working unchanged because it never checks concrete types.

### 8. Inherited vs. overridden behavior
*Inherited behavior* is a method the subclass uses exactly as the base class defined it
(shared, common behavior). *Overridden behavior* is a method the subclass replaces with its
own implementation (specialized behavior).

*Examples:* A `User` base class has `getName()`, which every subclass inherits unchanged.
A base `Vehicle` has `move()`; `Boat` overrides it to float while `Car` overrides it to
drive.

### 9. Why inheritance for reuse alone can be inappropriate
When there is no genuine "is-a" relationship, inheritance creates a false hierarchy that
forces unrelated classes into a shared contract they do not fully support. Consequences
include leaking irrelevant methods, violating the Liskov Substitution Principle, tight
coupling to the base class, fragile code (a base change breaks subclasses), and confusing
designs. Composition ("has-a") usually models such reuse better.

### 10. VehicleRental analysis
Common behavior across all rentals includes an identifier, a daily rate, a
`calculateRentalCost()` skeleton, and availability tracking. Specialized behavior differs:
`CarRental` might add an unlimited-mileage rule, while `TruckRental` adds a cargo-capacity
surcharge and a different insurance model.

Inheritance models this by putting the shared attributes and operations in a `VehicleRental`
base class and letting `CarRental` and `TruckRental` extend it, inheriting the common logic
and overriding only the parts unique to each rental type. New rental types can then be added
with minimal changes to the shared rental logic.
