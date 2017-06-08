package org.yoqu;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public static void main(String[] args) {
        String sql ="INSERT INTO adsring_dsp_platform.phonesection (number, province_name, province_code, city_name, city_code, message, status, carriers_code)\n" +
                "VALUES ('%s', '北京', '01', '北京', '010', null, 1, 1);";
        int value = 1781300;
        for (int i = 0; i < 40; i++) {
            String outSql = sql.replace("%s",String.valueOf(value));
            value ++;
            System.out.println(outSql);
        }
    }

    public void test(){

    }
}
