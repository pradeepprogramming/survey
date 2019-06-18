package com.example.canesurvey.util;

import com.softland.palmtecandro.palmtecandro;

public class PrinterPrint {
    public void PrintLine(String printstring)
    {
        palmtecandro.jnidevOpen(115200);
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
}
