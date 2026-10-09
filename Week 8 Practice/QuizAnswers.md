# Week 8 Practice - Quiz Answers

1. **C - Polymorphism.** Replacing type-based `if-else` checks with a single overridden
   `render()` call lets each `Document` subtype decide its own behavior at runtime.

2. **A and B.** `Car` is a `Vehicle` and `Rectangle` is a `Shape` are genuine "is-a"
   relationships. `DatabaseConnection` is not a kind of `NetworkResource`, and a
   `HelperUtility` *contains* a `Calculator` (that is a "has-a"/composition relationship).

3. **C - Runtime method dispatch.** The JVM looks at the actual object type at runtime and
   invokes the overridden `startEngine()` for each vehicle.

4. **C - Inheritance-based polymorphism.** Storing `Circle` and `Rectangle` as `Shape`
   references and calling `calculateArea()` demonstrates polymorphic behavior.

5. **A, C and D.**
   - A: `Book.getLoanPeriod()` extends inherited behavior with a new-release rule.
   - C: `LibraryItem` defines the common behavior shared by all items.
   - D: A `DVD` can be referenced and processed as a `LibraryItem`.
   - B is false because `DVD` overrides with its own fixed period, not shared behavior.

6. **A and C.**
   - A: A `Dog` referenced as an `Animal` executes `Dog`'s overridden `makeSound()`.
   - C: `Dog`'s `makeSound()` is overridden behavior.
   - B is false (the base method is the common/general behavior) and D is false
     (derived classes may add brand-new members without declaring them in the base).

7. **C.** Adding `WalletPayment` requires no change to the existing `PaymentProcessor`
   iteration logic; it keeps working through the `Payment` base reference.

8. **A.** Inheritance used only for superficial reuse creates incorrect "is-a" relationships
   and tight coupling, making the design rigid and hard to extend.

9. **A and C.**
   - A: A generic `NotificationSender` can send any notification without knowing its type.
   - C: A new channel such as `InAppNotification` can be added without touching existing
     sender logic.
   - B and D are false.

10. **A, B and C.**
    - A: It simplifies iterating over diverse but related objects.
    - B: It allows uniform processing of objects with specialized behavior.
    - C: It reduces the need for explicit type casting in common loops.
    - D is false; polymorphic collections actually make it *easier* to add new types.
