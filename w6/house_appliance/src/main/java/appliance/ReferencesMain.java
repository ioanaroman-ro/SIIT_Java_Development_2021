package appliance;

import appliance.model.SimpleLight;

public class ReferencesMain {
    public static void main(String[] args){
        float argument = 10;
        setValue(argument);
        System.out.println(argument);

        SimpleLight light = new SimpleLight("Example");
        light.brightness = 10.0f;
    }

    private static void setValue(float parameter){
        parameter = 20;
    }
}
