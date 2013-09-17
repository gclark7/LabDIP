INSTRUCTIONS:
===================================
Put your solution in the package "dip.lab1.student.solution1". And try not
to peek at the instructor solution. If you get stuck or want to check if your
solution is a good one, first review the instructor's solution. Now please
read on...

You have been presented with a description and purpose of the
Dependency Inversion Principle (DIP). You will need to understand this
principle to successfully complete the lab work.

DIP RULES:
    A. HIGH LEVEL MODULES SHOULD NOT DEPEND UPON LOW
       LEVEL MODULES. BOTH SHOULD DEPEND UPON ABSTRACTIONS.

    B. ABSTRACTIONS SHOULD NOT DEPEND UPON DETAILS. DETAILS
       SHOULD DEPEND UPON ABSTRACTIONS.

DIP OBJECTIVES:
    1. Reduce rigidity and fragility.
    2. Improve portability (code reuse, flexibility)

THE CHALLENGE:
--------------
This lab is full of bad programming ideas and poor practices.
In this lab #1 your main goal is to modify the high-level and low-level classes
to follow the DIP. Part of that involves making the high-level class use
delegation, in a polymorphic way (common behaviors), so as to be able to use
any low-level object as a delegate component. The problem is, both the
low-level and high-level classes are poorly designed.

Start with the low-level classes and ask yourself whether they follow the
DIP rules for low-level classes. Then look for, or create common methods
that can be executed polymorphically (with different implementations). Right
now you have some methods (behaviors) that are appropriate for one low-level
class, and other that are appropriate for the other low-level class.

You may need to change the super class to follow the DIP.

The high-level class should now be easy to modify. But beware, your instructor
has added lots of distractions to force you to think about what you are doing.
For example, an enum is declared. There's nothing wrong with enums, and in fact,
they promote type safety (your instructor will explain). However, the enum
has nothing to do with fixing the high-level class ... in fact, it's not needed
at all. So don't expect this to be simple and straight forward unless you
really, really, really understand the DIP. If you don't, you haven't spent
enough time studying. That's a clue for new study habits. If your low-level
classes follow the DIP, all you need to do is delegate to those objects in
a polymorphic way (call common method(s)). But you will need to change or
replace the existing methods to accomplish this.

DON'T ALLOW YOURSELF TO BE PARALYZED BY CONFUSION! ASK FOR HELP EARLY AND OFTEN!

//Employee
 // You gotta question if these are appropriate for ALL employees?
    private double hourlyRate;
    private double totalHrsForYear;
    private double annualSalary;
    private double annualBonus;

    /**
     * Returns annual wages for hourly workers. Is this polymorphic?
     * Could it be? Does it belong here?
     *
     * @return annual wages for hourly workers using the formula
     * annualWages = hourlyRate * totalHrsForYear
     */
    public double getAnnualWages() {
        return hourlyRate * totalHrsForYear;
    }

    /**
     * Returns annual bonus for salaried workers. Is this polymorphic?
     * Could it be? Does it belong here?
     *
     * @return annual bonus or zero if none.
     */
    public double getAnnualBonus() {
        return annualBonus;
    }

    /**
     * Is this polymorphic? Should it be? Does it belong here?
     * @param annualBonus -- think carefully about this
     */
    public void setAnnualBonus(double annualBonus) {
        this.annualBonus = annualBonus;
    }

    /**
     * Is this polymorphic? Should it be? Does it belong here?
     * @return
     */
    public double getAnnualSalary() {
        return annualSalary;
    }

    /**
     * Is this polymorphic? Should it be? Does it belong here?
     * @param annualSalary - think carefully about this
     */
    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    /**
     * Is this polymorphic? Should it be? Does it belong here?
     * @return
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Is this polymorphic? Should it be? Does it belong here?
     * @param hourlyRate -- think carefully about this
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * Is this polymorphic? Should it be? Does it belong here?
     * @return
     */
    public double getTotalHrsForYear() {
        return totalHrsForYear;
    }

    /**
     * Is this polymorphic? Should it be? Does it belong here?
     * @param totalHrsForYear -- think carefully about this
     */
    public void setTotalHrsForYear(double totalHrsForYear) {
        this.totalHrsForYear = totalHrsForYear;
    }


//HR
private static final String ERROR_MSG =
            "Cannot get annual wages because no valid employee type provided";
    private static final String ERROR_TITLE = "Employee Type Unknown";

    /**
     * This is a truly horrible way to make decisions. Very rigid and fragile!
     * @param e - an employee object (not truly polymorphic!)
     * employeeType - a String identifying the employee type. A constant
     * (see above) should be used for this, but can you guarantee it will be?
     * Are there other options? Hint: enum
     * @return the annual compensation for supported employee types
     */
    
    
    public double getAnnualCompensationForEmployee(Employee e,
            String employeeType)
    {
        double annualCompensation = 0;

        // One example of using fragile if logic to determine employee type.
        // If only we could use polymorphism instead!
        if(employeeType.equals(HOURLY_TYPE)) {
            annualCompensation = e.getAnnualWages();

        } else if(employeeType.equals(SALARIED_TYPE)) {
            annualCompensation = e.getAnnualSalary();

        } else {
            JOptionPane.showMessageDialog(
                    null, ERROR_MSG, ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
        }

        return annualCompensation;
    }


    /**
     * This is another truly horrible way to make decisions.
     * Very rigid and fragile!
     * @param e - an employee object (not truly polymorphic!)
     * @return the annual compensation for supported employee types
     */
    public double getAnnualCompensationForEmployee(Employee e) {
        double annualCompensation = 0;

        // One example of using fragile if logic to determine employee type.
        // If only we could use polymorphism!
        // NOTE: you don't need both versions (the one above and this one).
        // Find a single, better way, using DIP principles.
        if(e instanceof HourlyEmployee) {
            annualCompensation = e.getAnnualWages();

        } else if(e instanceof SalariedEmployee) {
            annualCompensation = e.getAnnualSalary();

        } else {
            JOptionPane.showMessageDialog(
                    null, ERROR_MSG, ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
        }

        return annualCompensation;
    }