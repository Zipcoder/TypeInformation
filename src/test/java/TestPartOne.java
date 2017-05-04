import org.junit.Test;

import java.awt.*;
import java.io.Serializable;
import static org.junit.Assert.*;

/**
 * Created by andrewwong on 5/4/17.
 */
public class TestPartOne {
    @Test
    public void classImplementsInterface_ClassIsDimensionInterfaceIsSerializable_DimensionImplementsSerializableIsTrue() {
        //Arrange
        Class<Dimension> dimension = new Dimension;
        PartOne partOne = new PartOne();
        String interfaceName = Serializable.class.getName();

        //Act
        boolean isImplemented = partOne.classImplementsInterface(, interfaceName);

        //Assert
        assertTrue(isImplemented);
    }
}
