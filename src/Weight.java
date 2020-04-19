public class Weight {

    private double kilogram;
    private double gram;
    private double milligram;

    public double getKilogram() {return kilogram;}

    public double getGram() {return gram;}

    public double getMilligram() {return milligram;}

    public Weight(String kilogramString, String gramString, String milligramString){
        if (!kilogramString.isEmpty()){
            this.kilogram = Double.parseDouble(kilogramString);
            this.gram = kilogram * 1000;
            this.milligram = gram * 1000;
        }
        else if (!gramString.isEmpty()){
            this.gram = Double.parseDouble(gramString);
            this.kilogram = gram / 1000;
            this.milligram = gram * 1000;
        }
        else if (!milligramString.isEmpty()){
            this.milligram = Double.parseDouble(milligramString);
            this.gram = milligram / 1000;
            this.kilogram = gram / 1000;
        }
    }
}
