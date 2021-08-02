package ch_10.exercise10_08;

/**
 * Write a test program that uses the Tax class to print the 2001 and 2009 tax tables for taxable
 * income from $50,000 to $60,000 with intervals of $1,000 for all four statuses.
 * The tax rates for the year 2009 were given in Table 3.2. The tax rates for 2001
 * are shown in Table 10.1.
 * Tax rate:
 * Single filers |  Married filing jointly or qualifying widow(er) | Married filing separately | Head of household
 * 15%   -> Up to $27,050 | Up to $45,200 |  Up to $22,600 | Up to $36,250
 * 27.5% -> $27,051–$65,550 | $45,201–$109,250 | $22,601–$54,625  |  $36,251–$93,650
 * 30.5% -> $65,551–$136,750 |  $109,251–$166,500 | $54,626–$83,250 |  $93,651–$151,650
 * 35.5% -> $136,751–$297,350 | $166,501–$297,350 |  $83,251–$148,675 |  $151,651–$297,350
 * 39.1% -> $297,351 or more |  $297,351 or more  |  $ 148,676 or more | $297,351 or more
 * TABLE 10.1 2001 United States Federal Personal Tax Rates
 */
public class Exercise10_08 {
    static final String COLUMN_HEADER = "Taxable Income |  Single Filer | Married jointly |  Married Separately |" +
            "  Head " +
            "Of House";

    public static void main(String[] args) {

        double[] rates2001 = {0.15, 0.275, 0.305, 0.355, 0.391};
        int[][] brackets2001 = {
                {27_050, 65_550, 136_750, 297_350}, // Single filer
                {45_200, 109_250, 166_500, 297_350}, // Married jointly -or qualifying widow(er)
                {22_600, 54_620, 83_250, 148_675}, // Married separately
                {36_250, 93_650, 151_650, 297_350} // Head of household
        };


        double[] rates2009 = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
        int[][] brackets2009 = {
                {8_350, 33_950, 82_250, 171_550, 372_950}, // Single filer
                {16_700, 67_900, 137_050, 20_885, 372_950}, // Married jointly  -or qualifying widow(er)
                {8_350, 33_950, 68_525, 104_425, 186_475}, // Married separately
                {11_950, 45_500, 117_450, 190_200, 372_950} // Head of household
        };
        System.out.println("__________________________________ Tax Tables for 2001 __________________________________");
        printH2();
        for (int taxableIncome = 50_000; taxableIncome <= 60_000; taxableIncome += 1000) {

            System.out.printf("\t%d", taxableIncome);

            Tax taxHelper = new Tax(Tax.SINGLE_FILER, brackets2001, rates2001, taxableIncome);
            System.out.printf("\t\t\t %.2f", taxHelper.getTax());

            taxHelper.setFilingStatus(Tax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOW_ER);
            System.out.printf("\t\t %.2f", taxHelper.getTax());

            taxHelper.setFilingStatus(Tax.MARRIED_SEPARATELY);
            System.out.printf("\t\t\t %.2f", taxHelper.getTax());

            taxHelper.setFilingStatus(Tax.HEAD_OF_HOUSEHOLD);
            System.out.printf("\t\t\t %.2f" + "\n", taxHelper.getTax());


        }
        System.out.println("__________________________________ Tax Tables for 2009 __________________________________");
        printH2();
        for (int taxableIncome = 50_000; taxableIncome <= 60_000; taxableIncome += 1000) {

            System.out.printf("\t%d", taxableIncome);

            Tax taxHelper2 = new Tax(Tax.SINGLE_FILER, brackets2009, rates2009, taxableIncome);
            System.out.printf("\t\t\t %.2f", taxHelper2.getTax());

            taxHelper2.setFilingStatus(Tax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOW_ER);
            System.out.printf("\t\t %.2f", taxHelper2.getTax());

            taxHelper2.setFilingStatus(Tax.MARRIED_SEPARATELY);
            System.out.printf("\t\t\t %.2f", taxHelper2.getTax());

            taxHelper2.setFilingStatus(Tax.HEAD_OF_HOUSEHOLD);
            System.out.printf("\t\t\t %.2f" + "\n", taxHelper2.getTax());


        }
    }

    static void printH2() {
        System.out.println(COLUMN_HEADER);

    }
}