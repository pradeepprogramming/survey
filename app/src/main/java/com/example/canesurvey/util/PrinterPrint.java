package com.example.canesurvey.util;

import android.util.Log;
import android.widget.Toast;

import com.softland.palmtecandro.palmtecandro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrinterPrint {

    int count,paperFeed=5;
    int[] tosnd;
    String receivedmsg="";
    byte[] bytearr,printcmd;

    public PrinterPrint()
    {
        palmtecandro.jnidevOpen(115200);
        tosnd = new int[16 * 1024];// to initialise the size as 16KB
        count = 0;

/*


        String texttoprint = "this is text to print";

        String[] column = new String[]{"Tax Invoice"};
        Integer[] margin = new Integer[]{26};                        //no of charecters that is supported in one line of the printer
        Integer[] align = new Integer[]{1};                            //alignment (0-left,1-center,2- right)

        String printeData = ESC.setCHARASTYLE(0, 0, 0, 0, 0)
                + ESC.printCOLUMN(column, margin, align) + ESC.NEWLINE;



        PrinterPrint print=new PrinterPrint();
        print.sendMessageTahi1(printeData+"file and data printing well and it is running also"+ESC.NEWLINE);
*/


    }


    public void PrintLine(String printstring)
    {

        byte[] byarr = printstring.getBytes();
        int ilan = 0, icount = 0;
        int ipos = 0;
        ilan = byarr.length;
        ilan += 4;

        int[] dataarr = new int[ilan];
        dataarr[0] = (byte) 0x1B;
        dataarr[1] = (byte) 0x21;
        dataarr[2] = (byte) 0x10;
        icount = 3;
        for (ipos = 0; icount < ilan-1; ipos++, icount++) {
            dataarr[icount] = byarr[ipos];
        }
        dataarr[icount] = (byte) 0x0A;
        palmtecandro.jnidevDataWrite(dataarr, ilan);

    }
    public void sendMessageTahi1( String message ) {
         receivedmsg = message;
        byte cmd = (byte) 0x10;
         count = 0;
        String hex = "", commandStr = "";
        if (message.length() > 0) {
            String str = message;
           // Toast.makeText(PrintDataActivity.this, "  Please wait Printing is in Progress ", Toast.LENGTH_SHORT).show();
            String[] strArray = str.split("<");
            try {

                for (int i = 0; i < strArray.length; i++) {
                    String mstr = "<" + strArray[i];
                    Pattern pattern = Pattern.compile("<(.*?)>");
                    Matcher matcher = pattern.matcher(mstr);
                    Log.e("", " inside try catch  inside for malliiiiiiiiii");
                    // Log.i("", ""+matcher);
                    cmd = (byte) 0x10;
                    String strPrintArray = "...........";
                    // mstr.replace("<"+matcher.group(1)+">","");
                    if (matcher.find()) {
                        strPrintArray = mstr.replace("<" + matcher.group(1) + ">", "");
                        // System.out.println(strPrintArray+"  1 "+matcher.group(1)+"  "+matcher.groupCount());
                        commandStr = matcher.group(1);
                        Log.e("dfsdf", "lengthis" + commandStr);

                        if (!commandStr.equals("0xPG")) {
                            try {
                                hex = matcher.group(1).replace("0x", "");
                                //   mChatService.write((byte) Integer.parseInt(hex, 16));
                                setCmd((byte)Integer.parseInt(hex,16));
                                Log.e("HEX = ",hex );
                                //    mChatService.write(strPrintArray.getBytes());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {

                            //InputStream stream = (InputStream) getAssets().open("robot.bmp");

                            final String imageStr = "";//ParkingDetails.imgstring;

                            //               Log.e("dfsdf", "lengthis" + bytearr.length);
                            if ( bytearr != null && bytearr.length > 0 && bytearr.length < 16000 ) {


                                setCmd(printcmd);
                                setCmd(bytearr);

                            }

                        }

                        int Strlength = strPrintArray.length();
                        //  int[] tosend = new int[ Strlength ];
                        byte[] _data = strPrintArray.getBytes();

                        for (int j = 0; j < Strlength; j++) {
                            //  tosend[ j ] = _data[ j ];
                            tosnd[count] = _data[j];
                            count++;
                        }
                    }


                    Log.e("", "remaining string: " + strPrintArray);
                }

                Log.e("counts : ","sil "+tosnd.length +" " + count );
                int splitLimit = 3090;
                if (count > splitLimit) {
                    int iCount = count / splitLimit;
                    int remain = count - (iCount * splitLimit);
                    int totCount = 0;
                    Thread.currentThread();
                    int[] _dataArrSplitRemain = new int[remain];
                    for (int i = 0; i < remain; i++) {

                        int icountNew = (iCount * splitLimit) + i;
                        _dataArrSplitRemain[i] = tosnd[icountNew];
                        //   System.out.println("totCount"+totCount + " " + i + " " + _dataArrSplitRemain[i]);
                        Log.e("totCount", "totCount" + totCount + " " + i + " " + _dataArrSplitRemain[i]);
                        totCount++;

                    }
                    for (int i = 0; i < iCount; i++) {
                        int[] _dataArrSplit = new int[splitLimit];
                        for (int j = 0; j < splitLimit; j++) {

                            int icountNew = (i * splitLimit) + j;
                            _dataArrSplit[j] = tosnd[icountNew];
                            //    System.out.println("totCount"+totCount + " " + j + " " + _dataArrSplit[j]);
                            Log.e("totCount", "totCount" + totCount + " " + j + " " + icountNew);
                            totCount++;
                        }

                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        palmtecandro.jnidevDataWrite(_dataArrSplit, splitLimit);
                    }


                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    palmtecandro.jnidevDataWrite(_dataArrSplitRemain, remain);
                    //  palmtecandro.jnidevDataWrite(tosnd, iCount);
                }
                else
                    palmtecandro.jnidevDataWrite(tosnd, count);
                // palmtecandro.jnidevDataWrite(tosnd, count);

                try {
                    // Thread.sleep(1500);
                    // ( ( Activity ) BluetoothChat.this ).finish();

                    //printButton.setText("Reprint");

                }
                catch (Exception e) {
                    e.printStackTrace();

                }

                //}
                // }
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
    private void setCmd(byte[] m)
    {
        for (int j = 0; j < m.length; j++)
        {
            tosnd[count] = m[j];
            count++;
        }
    }
    private void setCmd(byte cmd)
    {
        tosnd[count] = cmd;
        count++;
    }



}
