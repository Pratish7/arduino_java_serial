import com.fazecast.jSerialComm.*;

public class prog {

   public static void main(String[] args) throws Exception {
      SerialPort serials[] = SerialPort.getCommPorts();
      for (SerialPort serial : serials) {
         System.out.println(serial.getSystemPortName());
      }

      SerialPort sp = SerialPort.getCommPort("/dev/ttyACM0"); //Linux
      //SerialPort sp = SerialPort.getCommPort("COMXY"); //Windows
      sp.setComPortParameters(9600, 8, 1, 0);
      sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0); 
      if (sp.openPort()) {
         System.out.println("Port is open");
       } else {
         System.out.println("Failed to open port ");
       } 
       Integer i =0;
       sp.getOutputStream().write(i.byteValue());
       sp.getOutputStream().flush();
       System.out.println("Sent number: " + i);

       if (sp.closePort()) {
         System.out.println("Port is closed");
       } else {
         System.out.println("Failed to close port");
       }
       System.exit(0);


   }
}