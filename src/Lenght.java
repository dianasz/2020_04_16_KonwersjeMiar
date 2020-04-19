public class Lenght {

    private double meter;
    private double centimeter;
    private double millimeter;

    public double getMeter() {return meter;}

    public double getCentimeter() {return centimeter;}

    public double getMillimeter() {return millimeter;}

    public Lenght(String meterString, String centimeterString, String millimeterString){
        if (!meterString.isEmpty()){
            this.meter = Double.parseDouble(meterString);
            this.centimeter = meter * 100;
            this.millimeter = meter * 1000;
        }
        else if (!centimeterString.isEmpty()){
            this.centimeter = Double.parseDouble(centimeterString);
            this.meter = centimeter / 100;
            this.millimeter = centimeter * 10;
        }
        else if (!millimeterString.isEmpty()){
            this.millimeter = Double.parseDouble(millimeterString);
            this.centimeter = millimeter / 10;
            this.meter = millimeter / 1000;
        }
    }

}
