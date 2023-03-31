/*
Aaron James Vandersluys
221178806
SIT305
Task 2.1 P
 */

package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

/*
Importing the required packages into the project,
allowing me to link UI elements to Java code.
 */
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
    Variables which I have created to store the length
    values of the distances that I have used to perform
    the conversions. Doubles are utilised to store this
    data.
     */
    double inch = 2.54;
    double foot = 30.48;
    double yard = 91.44;

   /*
   convertUnits function, which contains functionality to convert
   units based on the users selected units to convert. Functionality
   is based on if...else statements to compare the units selected by
   the two UI spinners, allowing the user to choose to units.
    */
    private double convertUnits (double value, String sourceUnit, String destinationUnit) { // Function takes the value input by the user, and compares the two selected inputs from the spinners

        // Distance conversions, completed by dividing the appropriate length variables, based on user selections, when a match is found

        // Inches to...
        if (sourceUnit.equals("Inch") && destinationUnit.equals("Foot")) {
            return inch / foot;
        } else if (sourceUnit.equals("Inch") && destinationUnit.equals("Yard")) {
            return inch / yard;

        // Feet to...
        } else if (sourceUnit.equals("Foot") && destinationUnit.equals("Inch")) {
            return foot / inch;
        }
          else if (sourceUnit.equals("Foot") && destinationUnit.equals("Yard")) {
            return foot / yard;
        }

        // Yards to...
        else if (sourceUnit.equals("Yard") && destinationUnit.equals("Inch")) {
            return yard / inch;
        }
        else if (sourceUnit.equals("Yard") && destinationUnit.equals("Foot")) {
            return yard / foot;
        }

        // Weight conversions, completed by multiplying or dividing the users input value by 16, which is the number of ounces in one pound

        // pound to ounce
        else if (sourceUnit.equals("Pound") && destinationUnit.equals("Ounce")) {
            return value * 16;
        }

        // ounce to pound
        else if (sourceUnit.equals("Ounce") && destinationUnit.equals("Pound")) {
            return value / 16;
        }

        // Temperature conversions, with the appropriate calculations added to the return statement to convert between the users selected temperature

        // Celsius to fahrenheit
        else if (sourceUnit.equals("Celsius") && destinationUnit.equals("Fahrenheit")) {
            return (value * 1.8) + 32;
        }

        // Celsius to kelvin
        else if (sourceUnit.equals("Celsius") && destinationUnit.equals("Kelvin")) {
            return value + 273.15;
        }

        // Fahrenheit to celsius
        else if (sourceUnit.equals("Fahrenheit") && destinationUnit.equals("Celsius")) {
            return (value - 32) / 1.8;
        }

        // Kelvin to celsius
        else if (sourceUnit.equals("Kelvin") && destinationUnit.equals("Celsius")) {
            return value - 273.15;
        }
        else {
            return value;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        An array of string elements, which are used to populate the two spinners,
        and provide functionality allowing the convertUnits function to determine
        which if...else statement is required to execute.
         */
        String[] conversionUnits = {"Inch", "Foot", "Yard", "Pound", "Ounce", "Celsius", "Fahrenheit", "Kelvin"};

        // An array adapter, which is being used to to populate the array items inside the first (source unit) spinner, enabling user unit selection. Also connecting spinner to code and providing functionality.
        ArrayAdapter<String> sourceSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, conversionUnits);
        sourceSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sourceUnitSelectionSpinner = findViewById(R.id.sourceUnit);
        sourceUnitSelectionSpinner.setAdapter(sourceSpinner);

        // An array adapter, which is being used to to populate the array items inside the second (destination unit) spinner, enabling user unit selection. Also connecting spinner to code and providing functionality.
        ArrayAdapter<String> destinationSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, conversionUnits);
        destinationSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner destinationUnitSelectionSpinner = findViewById(R.id.destinationUnit);
        destinationUnitSelectionSpinner.setAdapter(destinationSpinner);

        Button conversionButton = findViewById(R.id.convertButton); // Connect convert button element to code, and add functionality with on click listener.
        conversionButton.setOnClickListener(new View.OnClickListener() {

            /*
            onClick function, which is utilised to execute code
            based on how the user interacts with the UI elements.
             */
            @Override
            public void onClick (View View) {

                // Capturing selected first (source unit) spinner option from user.
                Spinner sourceUnitSelectionSpinner = findViewById(R.id.sourceUnit);
                String sourceUnit = sourceUnitSelectionSpinner.getSelectedItem().toString();

                // Capturing selected second (destination unit) spinner option from user.
                Spinner destinationUnitSelectionSpinner = findViewById(R.id.destinationUnit);
                String destinationUnit = destinationUnitSelectionSpinner.getSelectedItem().toString();

                // Connecting the code for the EditText to the associated UI elements, capturing user value input.
                EditText inputUnit = findViewById(R.id.unitToConvert);
                double unitValue = Double.parseDouble(inputUnit.getText().toString());
                unitValue = convertUnits(unitValue, sourceUnit, destinationUnit); // calls convertUnit function, excepting user input value and sets unit value as converted results.

                // TextView connection to code, and display results of conversion to user.
                TextView conversionResult = findViewById(R.id.result);
                conversionResult.setText(String.valueOf(unitValue));
            }
        });

    }
}