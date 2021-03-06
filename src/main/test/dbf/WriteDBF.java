package dbf;

import JDBC.OJDBCUtils;
import com.linuxense.javadbf.DBFDataType;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFWriter;

import util.DateUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class WriteDBF {

    public static void writeDBF(String path) {
        Connection conn = null;
        PreparedStatement ps = null;
        OutputStream fos = null;
        DBFWriter df = null;
        try {
            fos = new FileOutputStream(path);
            df = new DBFWriter(fos, Charset.forName("GBK"));
            //定义DBF字段
            DBFField[] fields = new DBFField[87];
            fields[0] = new DBFField();
            fields[0].setName("PKIIB");
            fields[0].setType(DBFDataType.CHARACTER);
            fields[0].setLength(20);
            fields[1] = new DBFField();
            fields[1].setName("PKIIA");
            fields[1].setType(DBFDataType.CHARACTER);
            fields[1].setLength(254);
            fields[2] = new DBFField();
            fields[2].setName("DZWDH");
            fields[2].setType(DBFDataType.CHARACTER);
            fields[2].setLength(40);
            fields[3] = new DBFField();
            fields[3].setName("DAGMC");
            fields[3].setType(DBFDataType.CHARACTER);
            fields[3].setLength(30);
            fields[4] = new DBFField();
            fields[4].setName("DAGMC_DM");
            fields[4].setType(DBFDataType.CHARACTER);
            fields[4].setLength(10);
            fields[5] = new DBFField();
            fields[5].setName("ZLLBMC");
            fields[5].setType(DBFDataType.CHARACTER);
            fields[5].setLength(20);
            fields[6] = new DBFField();
            fields[6].setName("ZLLBDM");
            fields[6].setType(DBFDataType.CHARACTER);
            fields[6].setLength(2);
            fields[7] = new DBFField();
            fields[7].setName("GZCDMC");
            fields[7].setType(DBFDataType.CHARACTER);
            fields[7].setLength(14);
            fields[8] = new DBFField();
            fields[8].setName("GZCDDM");
            fields[8].setType(DBFDataType.CHARACTER);
            fields[8].setLength(2);
            fields[9] = new DBFField();
            fields[9].setName("KCMC1");
            fields[9].setType(DBFDataType.CHARACTER);
            fields[9].setLength(20);
            fields[10] = new DBFField();
            fields[10].setName("KCDM1");
            fields[10].setType(DBFDataType.CHARACTER);
            fields[10].setLength(5);
            fields[11] = new DBFField();
            fields[11].setName("KCMC2");
            fields[11].setType(DBFDataType.CHARACTER);
            fields[11].setLength(20);
            fields[12] = new DBFField();
            fields[12].setName("KCDM2");
            fields[12].setType(DBFDataType.CHARACTER);
            fields[12].setLength(5);
            fields[13] = new DBFField();
            fields[13].setName("KCMC3");
            fields[13].setType(DBFDataType.CHARACTER);
            fields[13].setLength(20);
            fields[14] = new DBFField();
            fields[14].setName("KCDM3");
            fields[14].setType(DBFDataType.CHARACTER);
            fields[14].setLength(5);
            fields[15] = new DBFField();
            fields[15].setName("KCMC4");
            fields[15].setType(DBFDataType.CHARACTER);
            fields[15].setLength(20);
            fields[16] = new DBFField();
            fields[16].setName("KCDM4");
            fields[16].setType(DBFDataType.CHARACTER);
            fields[16].setLength(5);
            fields[17] = new DBFField();
            fields[17].setName("KCMC5");
            fields[17].setType(DBFDataType.CHARACTER);
            fields[17].setLength(20);
            fields[18] = new DBFField();
            fields[18].setName("KCDM5");
            fields[18].setType(DBFDataType.CHARACTER);
            fields[18].setLength(5);
            fields[19] = new DBFField();
            fields[19].setName("KCMC6");
            fields[19].setType(DBFDataType.CHARACTER);
            fields[19].setLength(20);
            fields[20] = new DBFField();
            fields[20].setName("KCDM6");
            fields[20].setType(DBFDataType.CHARACTER);
            fields[20].setLength(5);
            fields[21] = new DBFField();
            fields[21].setName("KCMC7");
            fields[21].setType(DBFDataType.CHARACTER);
            fields[21].setLength(20);
            fields[22] = new DBFField();
            fields[22].setName("KCDM7");
            fields[22].setType(DBFDataType.CHARACTER);
            fields[22].setLength(5);
            fields[23] = new DBFField();
            fields[23].setName("KCMC8");
            fields[23].setType(DBFDataType.CHARACTER);
            fields[23].setLength(20);
            fields[24] = new DBFField();
            fields[24].setName("KCDM8");
            fields[24].setType(DBFDataType.CHARACTER);
            fields[24].setLength(5);
            fields[25] = new DBFField();
            fields[25].setName("KCMC9");
            fields[25].setType(DBFDataType.CHARACTER);
            fields[25].setLength(20);
            fields[26] = new DBFField();
            fields[26].setName("KCDM9");
            fields[26].setType(DBFDataType.CHARACTER);
            fields[26].setLength(5);
            fields[27] = new DBFField();
            fields[27].setName("KCMC10");
            fields[27].setType(DBFDataType.CHARACTER);
            fields[27].setLength(20);
            fields[28] = new DBFField();
            fields[28].setName("KCDM10");
            fields[28].setType(DBFDataType.CHARACTER);
            fields[28].setLength(5);
            fields[29] = new DBFField();
            fields[29].setName("KCMC11");
            fields[29].setType(DBFDataType.CHARACTER);
            fields[29].setLength(20);
            fields[30] = new DBFField();
            fields[30].setName("KCDM11");
            fields[30].setType(DBFDataType.CHARACTER);
            fields[30].setLength(5);
            fields[31] = new DBFField();
            fields[31].setName("KCMC12");
            fields[31].setType(DBFDataType.CHARACTER);
            fields[31].setLength(20);
            fields[32] = new DBFField();
            fields[32].setName("KCDM12");
            fields[32].setType(DBFDataType.CHARACTER);
            fields[32].setLength(5);
            fields[33] = new DBFField();
            fields[33].setName("KCMC13");
            fields[33].setType(DBFDataType.CHARACTER);
            fields[33].setLength(20);
            fields[34] = new DBFField();
            fields[34].setName("KCDM13");
            fields[34].setType(DBFDataType.CHARACTER);
            fields[34].setLength(5);
            fields[35] = new DBFField();
            fields[35].setName("KCMC14");
            fields[35].setType(DBFDataType.CHARACTER);
            fields[35].setLength(20);
            fields[36] = new DBFField();
            fields[36].setName("KCDM14");
            fields[36].setType(DBFDataType.CHARACTER);
            fields[36].setLength(5);
            fields[37] = new DBFField();
            fields[37].setName("KCMC15");
            fields[37].setType(DBFDataType.CHARACTER);
            fields[37].setLength(20);
            fields[38] = new DBFField();
            fields[38].setName("KCDM15");
            fields[38].setType(DBFDataType.CHARACTER);
            fields[38].setLength(5);
            fields[39] = new DBFField();
            fields[39].setName("XZQMC1");
            fields[39].setType(DBFDataType.CHARACTER);
            fields[39].setLength(50);
            fields[40] = new DBFField();
            fields[40].setName("XZQDM1");
            fields[40].setType(DBFDataType.CHARACTER);
            fields[40].setLength(6);
            fields[41] = new DBFField();
            fields[41].setName("XZQMC2");
            fields[41].setType(DBFDataType.CHARACTER);
            fields[41].setLength(50);
            fields[42] = new DBFField();
            fields[42].setName("XZQDM2");
            fields[42].setType(DBFDataType.CHARACTER);
            fields[42].setLength(6);
            fields[43] = new DBFField();
            fields[43].setName("XZQMC3");
            fields[43].setType(DBFDataType.CHARACTER);
            fields[43].setLength(50);
            fields[44] = new DBFField();
            fields[44].setName("XZQDM3");
            fields[44].setType(DBFDataType.CHARACTER);
            fields[44].setLength(6);
            fields[45] = new DBFField();
            fields[45].setName("PKIIF");
            fields[45].setType(DBFDataType.CHARACTER);
            fields[45].setLength(100);
            fields[46] = new DBFField();
            fields[46].setName("PKIIG");
            fields[46].setType(DBFDataType.CHARACTER);
            fields[46].setLength(40);
            fields[47] = new DBFField();
            fields[47].setName("PZJG");
            fields[47].setType(DBFDataType.CHARACTER);
            fields[47].setLength(40);
            fields[48] = new DBFField();
            fields[48].setName("LEIX");
            fields[48].setType(DBFDataType.CHARACTER);
            fields[48].setLength(4);
            fields[49] = new DBFField();
            fields[49].setName("YUZ");
            fields[49].setType(DBFDataType.CHARACTER);
            fields[49].setLength(16);
            fields[50] = new DBFField();
            fields[50].setName("PKIID_MC");
            fields[50].setType(DBFDataType.CHARACTER);
            fields[50].setLength(4);
            fields[51] = new DBFField();
            fields[51].setName("PKIID");
            fields[51].setType(DBFDataType.CHARACTER);
            fields[51].setLength(1);
            fields[52] = new DBFField();
            fields[52].setName("BGQX");
            fields[52].setType(DBFDataType.CHARACTER);
            fields[52].setLength(4);
            fields[53] = new DBFField();
            fields[53].setName("BHQ");
            fields[53].setType(DBFDataType.DATE);
            fields[53].setLength(8);
            fields[54] = new DBFField();
            fields[54].setName("YBBC");
            fields[54].setType(DBFDataType.CHARACTER);
            fields[54].setLength(100);
            fields[55] = new DBFField();
            fields[55].setName("YKXBC");
            fields[55].setType(DBFDataType.CHARACTER);
            fields[55].setLength(150);
            fields[56] = new DBFField();
            fields[56].setName("XCSJ");
            fields[56].setType(DBFDataType.DATE);
            fields[56].setLength(8);
            fields[57] = new DBFField();
            fields[57].setName("QSSJ");
            fields[57].setType(DBFDataType.DATE);
            fields[57].setLength(8);
            fields[58] = new DBFField();
            fields[58].setName("ZZSJ");
            fields[58].setType(DBFDataType.DATE);
            fields[58].setLength(8);
            fields[59] = new DBFField();
            fields[59].setName("PZSJ");
            fields[59].setType(DBFDataType.DATE);
            fields[59].setLength(8);
            fields[60] = new DBFField();
            fields[60].setName("HJSJ");
            fields[60].setType(DBFDataType.DATE);
            fields[60].setLength(8);
            fields[61] = new DBFField();
            fields[61].setName("QSJD0");
            fields[61].setType(DBFDataType.CHARACTER);
            fields[61].setLength(1);
            fields[62] = new DBFField();
            fields[62].setName("QSJD1");
            fields[62].setType(DBFDataType.CHARACTER);
            fields[62].setLength(3);
            fields[63] = new DBFField();
            fields[63].setName("QSJD2");
            fields[63].setType(DBFDataType.CHARACTER);
            fields[63].setLength(2);
            fields[64] = new DBFField();
            fields[64].setName("QSJD3");
            fields[64].setType(DBFDataType.CHARACTER);
            fields[64].setLength(2);
            fields[65] = new DBFField();
            fields[65].setName("ZZJD0");
            fields[65].setType(DBFDataType.CHARACTER);
            fields[65].setLength(1);
            fields[66] = new DBFField();
            fields[66].setName("ZZJD1");
            fields[66].setType(DBFDataType.CHARACTER);
            fields[66].setLength(3);
            fields[67] = new DBFField();
            fields[67].setName("ZZJD2");
            fields[67].setType(DBFDataType.CHARACTER);
            fields[67].setLength(2);
            fields[68] = new DBFField();
            fields[68].setName("ZZJD3");
            fields[68].setType(DBFDataType.CHARACTER);
            fields[68].setLength(2);
            fields[69] = new DBFField();
            fields[69].setName("QSWD0");
            fields[69].setType(DBFDataType.CHARACTER);
            fields[69].setLength(1);
            fields[70] = new DBFField();
            fields[70].setName("QSWD1");
            fields[70].setType(DBFDataType.CHARACTER);
            fields[70].setLength(2);
            fields[71] = new DBFField();
            fields[71].setName("QSWD2");
            fields[71].setType(DBFDataType.CHARACTER);
            fields[71].setLength(2);
            fields[72] = new DBFField();
            fields[72].setName("QSWD3");
            fields[72].setType(DBFDataType.CHARACTER);
            fields[72].setLength(2);
            fields[73] = new DBFField();
            fields[73].setName("ZZWD0");
            fields[73].setType(DBFDataType.CHARACTER);
            fields[73].setLength(1);
            fields[74] = new DBFField();
            fields[74].setName("ZZWD1");
            fields[74].setType(DBFDataType.CHARACTER);
            fields[74].setLength(2);
            fields[75] = new DBFField();
            fields[75].setName("ZZWD2");
            fields[75].setType(DBFDataType.CHARACTER);
            fields[75].setLength(2);
            fields[76] = new DBFField();
            fields[76].setName("ZZWD3");
            fields[76].setType(DBFDataType.CHARACTER);
            fields[76].setLength(2);
            fields[77] = new DBFField();
            fields[77].setName("NRTY");
            fields[77].setType(DBFDataType.CHARACTER);
            fields[78] = new DBFField();
            fields[78].setName("ZTC");
            fields[78].setType(DBFDataType.CHARACTER);
            fields[78].setLength(80);
            fields[79] = new DBFField();
            fields[79].setName("ZTC_KCH");
            fields[79].setType(DBFDataType.CHARACTER);
            fields[79].setLength(240);
            fields[80] = new DBFField();
            fields[80].setName("A_PKIIB");
            fields[80].setType(DBFDataType.CHARACTER);
            fields[80].setLength(6);
            fields[81] = new DBFField();
            fields[81].setName("HJLB");
            fields[81].setType(DBFDataType.CHARACTER);
            fields[81].setLength(1);
            fields[82] = new DBFField();
            fields[82].setName("HJLD");
            fields[82].setType(DBFDataType.CHARACTER);
            fields[82].setLength(10);
            fields[83] = new DBFField();
            fields[83].setName("HJDWDM");
            fields[83].setType(DBFDataType.CHARACTER);
            fields[83].setLength(4);
            fields[84] = new DBFField();
            fields[84].setName("HJDW");
            fields[84].setType(DBFDataType.CHARACTER);
            fields[84].setLength(20);
            fields[85] = new DBFField();
            fields[85].setName("S_PKIIB");
            fields[85].setType(DBFDataType.CHARACTER);
            fields[85].setLength(20);
            fields[86] = new DBFField();
            fields[86].setName("FUZHU");
            fields[86].setType(DBFDataType.CHARACTER);
            fields[86].setLength(150);
            df.setFields(fields);
            conn = OJDBCUtils.getConn();
            String sql = "select * from DZZL_CATALOG order by PKIIB";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object[] rowData = new Object[87];
                String PKIIB = rs.getString("PKIIB");
                String PKIIA = rs.getString("PKIIA");
                String DZWDH = rs.getString("DZWDH");
                String ZLLBMC = rs.getString("ZLLBMC");
                String ZLLBDM = rs.getString("ZLLBDM");
                String GZCDMC = rs.getString("GZCDMC");
                String GZCDDM = rs.getString("GZCDDM");
                String KCMC1 = rs.getString("KCMC1");
                String KCDM1 = rs.getString("KCDM1");
                String KCMC2 = rs.getString("KCMC2");
                String KCDM2 = rs.getString("KCDM2");
                String KCMC3 = rs.getString("KCMC3");
                String KCDM3 = rs.getString("KCDM3");
                String KCMC4 = rs.getString("KCMC4");
                String KCDM4 = rs.getString("KCDM4");
                String KCMC5 = rs.getString("KCMC5");
                String KCDM5 = rs.getString("KCDM5");
                String KCMC6 = rs.getString("KCMC6");
                String KCDM6 = rs.getString("KCDM6");
                String KCMC7 = rs.getString("KCMC7");
                String KCDM7 = rs.getString("KCDM7");
                String KCMC8 = rs.getString("KCMC8");
                String KCDM8 = rs.getString("KCDM8");
                String KCMC9 = rs.getString("KCMC9");
                String KCDM9 = rs.getString("KCDM9");
                String KCMC10 = rs.getString("KCMC10");
                String KCDM10 = rs.getString("KCDM10");
                String KCMC11 = rs.getString("KCMC11");
                String KCDM11 = rs.getString("KCDM11");
                String KCMC12 = rs.getString("KCMC12");
                String KCDM12 = rs.getString("KCDM12");
                String KCMC13 = rs.getString("KCMC13");
                String KCDM13 = rs.getString("KCDM13");
                String KCMC14 = rs.getString("KCMC14");
                String KCDM14 = rs.getString("KCDM14");
                String KCMC15 = rs.getString("KCMC15");
                String KCDM15 = rs.getString("KCDM15");
                String XZQMC1 = rs.getString("XZQMC1");
                String XZQDM1 = rs.getString("XZQDM1");
                String XZQMC2 = rs.getString("XZQMC2");
                String XZQDM2 = rs.getString("XZQDM2");
                String XZQMC3 = rs.getString("XZQMC3");
                String XZQDM3 = rs.getString("XZQDM3");
                String PKIIF = rs.getString("PKIIF");
                String PKIIG = rs.getString("PKIIG");
                String PZJG = rs.getString("PZJG");
                String LEIX = rs.getString("LEIX");
                String YUZ = rs.getString("YUZ");
                String PKIID_MC = rs.getString("PKIID_MC");
                String PKIID = rs.getString("PKIID");
                String BGQX = rs.getString("BGQX");
                String bhq = rs.getString("BHQ");
                Date BHQ = null;
                if (!"".equals(bhq) && !"null".equals(bhq) && bhq != null) {
                    BHQ = DateUtil.fomatDate(DateUtil.formatDateString(bhq));
                }
                String YBBC = rs.getString("YBBC");
                String YKXBC = rs.getString("YKXBC");
                String xcsj = rs.getString("XCSJ");
                Date XCSJ = null;
                if (!"".equals(xcsj) && !"null".equals(xcsj) && xcsj != null) {
                    XCSJ = DateUtil.fomatDate(DateUtil.formatDateString(xcsj));
                }
                String qssj = rs.getString("QSSJ");
                Date QSSJ = null;
                if (!"".equals(qssj) && !"null".equals(qssj) && qssj != null) {
                    QSSJ = DateUtil.fomatDate(DateUtil.formatDateString(qssj));
                }
                String zzsj = rs.getString("ZZSJ");
                Date ZZSJ = null;
                if (!"".equals(zzsj) && !"null".equals(zzsj) && zzsj != null) {
                    ZZSJ = DateUtil.fomatDate(DateUtil.formatDateString(zzsj));
                }
                String pzsj = rs.getString("PZSJ");
                Date PZSJ = null;
                if (!"".equals(pzsj) && !"null".equals(pzsj) && pzsj != null) {
                    PZSJ = DateUtil.fomatDate(DateUtil.formatDateString(pzsj));
                }
                String hjsh = rs.getString("HJSJ");
                Date HJSJ = null;
                if (!"".equals(hjsh) && !"null".equals(hjsh) && hjsh != null) {
                    HJSJ = DateUtil.fomatDate(DateUtil.formatDateString(hjsh));
                }
                String QSJD0 = rs.getString("QSJD0");
                String QSJD1 = rs.getString("QSJD1");
                String QSJD2 = rs.getString("QSJD2");
                String QSJD3 = rs.getString("QSJD3");
                String ZZJD0 = rs.getString("ZZJD0");
                String ZZJD1 = rs.getString("ZZJD1");
                String ZZJD2 = rs.getString("ZZJD2");
                String ZZJD3 = rs.getString("ZZJD3");
                String QSWD0 = rs.getString("QSWD0");
                String QSWD1 = rs.getString("QSWD1");
                String QSWD2 = rs.getString("QSWD2");
                String QSWD3 = rs.getString("QSWD3");
                String ZZWD0 = rs.getString("ZZWD0");
                String ZZWD1 = rs.getString("ZZWD1");
                String ZZWD2 = rs.getString("ZZWD2");
                String ZZWD3 = rs.getString("ZZWD3");
                String NRTY = rs.getString("NRTY");
                String ZTC = rs.getString("ZTC");
                String ZTC_KCH = rs.getString("ZTC_KCH");
                String A_PKIIB = rs.getString("A_PKIIB");
                String HJLB = rs.getString("HJLB");
                String HJLD = rs.getString("HJLD");
                String HJDWDM = rs.getString("HJDWDM");
                String HJDW = rs.getString("HJDW");
                String S_PKIIB = rs.getString("S_PKIIB");
                String DAGMC = rs.getString("DAGMC");
                String DAGMC_DM = rs.getString("DAGMC_DM");
                String FUZHU = rs.getString("FUZHU");
                rowData[0] = PKIIB;
                rowData[1] = PKIIA;
                rowData[2] = DZWDH;
                rowData[3] = DAGMC;
                rowData[4] = DAGMC_DM;
                rowData[5] = ZLLBMC;
                rowData[6] = ZLLBDM;
                rowData[7] = GZCDMC;
                rowData[8] = GZCDDM;
                rowData[9] = KCMC1;
                rowData[10] = KCDM1;
                rowData[11] = KCMC2;
                rowData[12] = KCDM2;
                rowData[13] = KCMC3;
                rowData[14] = KCDM3;
                rowData[15] = KCMC4;
                rowData[16] = KCDM4;
                rowData[17] = KCMC5;
                rowData[18] = KCDM5;
                rowData[19] = KCMC6;
                rowData[20] = KCDM6;
                rowData[21] = KCMC7;
                rowData[22] = KCDM7;
                rowData[23] = KCMC8;
                rowData[24] = KCDM8;
                rowData[25] = KCMC9;
                rowData[26] = KCDM9;
                rowData[27] = KCMC10;
                rowData[28] = KCDM10;
                rowData[29] = KCMC11;
                rowData[30] = KCDM11;
                rowData[31] = KCMC12;
                rowData[32] = KCDM12;
                rowData[33] = KCMC13;
                rowData[34] = KCDM13;
                rowData[35] = KCMC14;
                rowData[36] = KCDM14;
                rowData[37] = KCMC15;
                rowData[38] = KCDM15;
                rowData[39] = XZQMC1;
                rowData[40] = XZQDM1;
                rowData[41] = XZQMC2;
                rowData[42] = XZQDM2;
                rowData[43] = XZQMC3;
                rowData[44] = XZQDM3;
                rowData[45] = PKIIF;
                rowData[46] = PKIIG;
                rowData[47] = PZJG;
                rowData[48] = LEIX;
                rowData[49] = YUZ;
                rowData[50] = PKIID_MC;
                rowData[51] = PKIID;
                rowData[52] = BGQX;
                rowData[53] = BHQ;
                rowData[54] = YBBC;
                rowData[55] = YKXBC;
                rowData[56] = XCSJ;
                rowData[57] = QSSJ;
                rowData[58] = ZZSJ;
                rowData[59] = PZSJ;
                rowData[60] = HJSJ;
                rowData[61] = QSJD0;
                rowData[62] = QSJD1;
                rowData[63] = QSJD2;
                rowData[64] = QSJD3;
                rowData[65] = ZZJD0;
                rowData[66] = ZZJD1;
                rowData[67] = ZZJD2;
                rowData[68] = ZZJD3;
                rowData[69] = QSWD0;
                rowData[70] = QSWD1;
                rowData[71] = QSWD2;
                rowData[72] = QSWD3;
                rowData[73] = ZZWD0;
                rowData[74] = ZZWD1;
                rowData[75] = ZZWD2;
                rowData[76] = ZZWD3;
                rowData[77] = NRTY;
                rowData[78] = ZTC;
                rowData[79] = ZTC_KCH;
                rowData[80] = A_PKIIB;
                rowData[81] = HJLB;
                rowData[82] = HJLD;
                rowData[83] = HJDWDM;
                rowData[84] = HJDW;
                rowData[85] = S_PKIIB;
                rowData[86] = FUZHU;
                df.addRecord(rowData);
                System.out.println("导出数据：" + PKIIB + "-->" + PKIIA);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                df.close();
                fos.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        writeDBF("E:\\西安\\test.DBF");
    }
}
