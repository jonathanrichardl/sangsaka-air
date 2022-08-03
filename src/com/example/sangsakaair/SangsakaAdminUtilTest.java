package com.example.sangsakaair;

import com.example.sangsakaair.aircraft.Aircraft;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class SangsakaAdminUtilTest {
    @Test
    void testAircraftAddition() throws Exception{
        ArrayList<Aircraft> testList = new ArrayList<Aircraft>();
        String rightType = "bCs1";
        String wrongType = "A20N";
        String rightRegistration = "PK-saa";
        String wrongRegistration = "PK-GMA";
        SangsakaAdminUtil.registerAircraft(testList, rightType, rightRegistration);
        Assertions.assertThrows(Exception.class, () -> {
            SangsakaAdminUtil.registerAircraft(testList, rightType, wrongRegistration);
        });

        Assertions.assertThrows(Exception.class, () -> {
            SangsakaAdminUtil.registerAircraft(testList, wrongType, wrongRegistration);
        });

        Assertions.assertThrows(Exception.class, () -> {
            SangsakaAdminUtil.registerAircraft(testList, wrongType, rightRegistration);
        });

        assert testList.size() == 1;



    }
}
