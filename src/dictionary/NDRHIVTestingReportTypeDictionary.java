/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import com.inductivehealth.ndr.schema.HIVTestResultType;
import com.inductivehealth.ndr.schema.IndexNotificationServicesType;
import com.inductivehealth.ndr.schema.PostTestCounsellingType;
import com.inductivehealth.ndr.schema.PreTestInformationType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.datapump.Demographics;
import model.datapump.Obs;

/**
 *
 * @author The Bright
 */
public class NDRHIVTestingReportTypeDictionary {

    /*
         HIVTestingReportingType
          -ClientCode
          -VisitDate
          -VisitID
          -Setting (Values: 1,2,3...9)
          -FirstTimeVisit (Values: Y,N)
          -SessionType (Values: 1,2,3)
          -ReferredFrom (Values: 1,2,3,...8)
          -MaritalStatus (Values: S,M,D,A,G,W)
          -NoOfOwnChildrenLessThan5Years (int)
          -NoOfAllWives (int)
          -IsIndexClient (Values: Y,N)
          -IndexType (Values: 1,2,3)
          -IndexClientId
          -ReTestingForResultVerification (Values: N,Y)
          -PreTestInformation (PreTestInformationType)
          -HIVTestResult (HIVTestResultType)
          -PostTestCounselling (PostTestCounsellingType)
          -SyphilisTestResult (Values: R,NR)
          -HBVTestResult (Values: Pos,Neg)
          -HCVTestResult (Values: Pos,Neg)
          -IndexNotificationServices (IndexNotificationServicesType)
          -CompletedBy
          -DateCompleted
     */
    private Map<Integer, String> ndrCodingMap = null;

    public NDRHIVTestingReportTypeDictionary() {
      loadDictionary();
    }

    private void loadDictionary() {
        ndrCodingMap=new HashMap<Integer,String>();
        //Setting
        ndrCodingMap.put(160539, "1");//Voluntary counseling and testing program 
        ndrCodingMap.put(160529, "2");//Tuberculosis Visit 
        ndrCodingMap.put(160546, "3");//Sexually transmitted infection program/clinic 
        ndrCodingMap.put(5271, "4");//FAMILY PLANNING 
        ndrCodingMap.put(160542, "5");//Outpatient department 
        ndrCodingMap.put(161629, "6");//Observation ward 
        ndrCodingMap.put(165788, "7");//Blood Bank 
        ndrCodingMap.put(165838, "8");//Standalone HTS 
        //ndrCodingMap.put(5622, "9");//Other 
        //First time Visit
        ndrCodingMap.put(1065, "Y");//Yes
        ndrCodingMap.put(1066, "N");//No
        //SessionType
        ndrCodingMap.put(165792, "1");//Individual 
        ndrCodingMap.put(165789, "2");//Couple testing 
        ndrCodingMap.put(165885, "3");//Previously self tested 
        //ReferredFrom
        ndrCodingMap.put(978, "1");//SELF 
        ndrCodingMap.put(160529, "2");//Tuberculosis Visit 
        ndrCodingMap.put(160546, "3");//Sexually transmitted infection program/clinic 
        ndrCodingMap.put(5271, "4");//FAMILY PLANNING 
        ndrCodingMap.put(160542, "5");//Outpatient department 
        ndrCodingMap.put(161629, "6");//Observation ward 
        ndrCodingMap.put(165788, "7");//Blood Bank 
        //ndrCodingMap.put(5622, "8");//Other 
        //Marrital Status
        ndrCodingMap.put(1057, "S");//Never married 
        ndrCodingMap.put(5555, "M");//Married 
        ndrCodingMap.put(1058, "D");//Divorced 
        ndrCodingMap.put(1056, "A");//Separated 
        ndrCodingMap.put(1060, "G");//Living with partner 
        ndrCodingMap.put(1059, "W");//Widowed 
        //IndexType
        ndrCodingMap.put(165796, "1");//Biological 
        ndrCodingMap.put(165797, "2");//Sexual 
        ndrCodingMap.put(165795, "3");//Social 
        //SyphilisTest
        ndrCodingMap.put(1228, "R");//REACTIVE 
        ndrCodingMap.put(1229, "NR");//NON-REACTIVE 
        //HBVTestResult
        ndrCodingMap.put(703, "Pos");//Positive
        ndrCodingMap.put(664, "Neg");//Negative 
        //HCVTestResult (Same as HBVTestResult)
        
        
    }
    public HIVTestResultType createHIVTestingResultType(List<Obs> obsList, Demographics demo){
        HIVTestResultType hivTestResultType=new HIVTestResultType();
        return hivTestResultType;
    }
    public PreTestInformationType createPreTestInformationType(List<Obs> obsList,Demographics pts){
        PreTestInformationType preTest=new PreTestInformationType();
        return preTest;
    }
    public HIVTestResultType createHIVTestResultType(List<Obs> obsList,Demographics pts){
        HIVTestResultType hivTestResultType=new HIVTestResultType();
        return hivTestResultType;
    }
    public PostTestCounsellingType createPostTestCounsellingType(List<Obs> obsList,Demographics pts){
        PostTestCounsellingType postTest=new PostTestCounsellingType();
        return postTest;
    }
    public IndexNotificationServicesType createIndexNotificationServices(List<Obs> obsList,Demographics pts){
        IndexNotificationServicesType indexService=new IndexNotificationServicesType();
        return indexService;
    }

}
