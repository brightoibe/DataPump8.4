/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import com.inductivehealth.ndr.client.Client;
import com.inductivehealth.ndr.schema.ClinicalTBScreeningType;
import com.inductivehealth.ndr.schema.CodedSimpleType;
import com.inductivehealth.ndr.schema.HIVRiskAssessmentType;
import com.inductivehealth.ndr.schema.HIVTestResultType;
import com.inductivehealth.ndr.schema.IndexNotificationServicesType;
import com.inductivehealth.ndr.schema.KnowledgeAssessmentType;
import com.inductivehealth.ndr.schema.PostTestCounsellingType;
import com.inductivehealth.ndr.schema.PreTestInformationType;
import com.inductivehealth.ndr.schema.RecencyTestingType;
import com.inductivehealth.ndr.schema.SyndromicSTIScreeningType;
import com.inductivehealth.ndr.schema.TestResultType;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.datatype.DatatypeConfigurationException;
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

    public String getNDRCodedValue(int valueCoded) {
        String code = ndrCodingMap.get(valueCoded);
        return code;

    }

    private void loadDictionary() {
        ndrCodingMap = new HashMap<Integer, String>();
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
        //Rapid recency assay (165853)
        ndrCodingMap.put(165852, "R");// Recent -> Recent (165852)
        ndrCodingMap.put(165851, "L");//Long Term -> Long Term (165851)

    }

    public HIVTestResultType createHIVTestingResultType(List<Obs> obsList, Demographics demo) {
        HIVTestResultType hivTestResultType = new HIVTestResultType();
        return hivTestResultType;
    }

    public PreTestInformationType createPreTestInformationType(List<Obs> obsList, Demographics pts) {
        PreTestInformationType preTest = null;

        return preTest;
    }

    public boolean convertYesNoValueCodedToBoolean(int valueCoded) {
        boolean ans = false;
        if (valueCoded == 1065) {
            ans = true;
        } else if (valueCoded == 1066) {
            ans = false;
        }
        return ans;
    }

    public HIVTestResultType createHIVTestResultType(List<Obs> obsList, Demographics pts) {
        HIVTestResultType hivTestResultType = new HIVTestResultType();
        return hivTestResultType;
    }

    public TestResultType createTestResultType(List<Obs> obsList, Demographics pts) throws DatatypeConfigurationException {
        TestResultType testResultType = null;
        int conceptID = 0, valueCoded = 0;
        String valueText = "";
        Date valueDate = null;
        double valueNumeric = 0.0;
        CodedSimpleType cst = null;
        /*
            HIV Screening Test (165840)
              -Reactive -> REACTIVE (1228)
              -Non-reactive -> NON-REACTIVE (1229)
            HIV Screening Test Date (165844)
            HIV Confirmatory Test (165841) 
              -Reactive -> REACTIVE (1228)
              -Non-reactive -> NON-REACTIVE (1229)
            HIV Confirmatory Test Date (165845)
            Tie Breaker (165842) 
              -Reactive -> REACTIVE (1228)
              -Non-reactive -> NON-REACTIVE (1229)  
            Tie Breaker Date (165846) 
            HIV Final Result (165843) 
              -Positive -> Positive (703)
              -Negative -> Negative (664) 
           
         */
        if (!obsList.isEmpty()) {
            testResultType = new TestResultType();
            for (Obs obs : obsList) {
                conceptID = obs.getConceptID();
                switch (conceptID) {
                    case 165840://HIV Screening Test (165840)
                        valueCoded = obs.getValueCoded();
                        testResultType.setScreeningTestResult(getNDRCodedValue(valueCoded));
                        break;
                    case 165844: //HIV Screening Test Date (165844)
                        valueDate=obs.getValueDate();
                        testResultType.setScreeningTestResultDate(Client.getXmlDate(valueDate));
                        break;
                }
            }
        }
        return testResultType;
    }

    public RecencyTestingType createRecencyTestingType(List<Obs> obsList, Demographics pts) throws DatatypeConfigurationException {
        /*
            	HIV Recency Test Name (165849) 	
                HIV Recency Test Date (165850)
                Rapid recency assay (165853) 
                    -Recent -> Recent (165852)
                    -Long Term -> Long Term (165851) 
                Sample test date (165854)
                HIV VIRAL LOAD (856) 
                Final HIV recent infection testing algorithm result (165856)
                    -Long Term -> Long Term (165851) 
                    -Recent -> Recent (165852)
                    -Long Term -> Long Term (165851)         
         */
        RecencyTestingType recencyTestResultType = null;
        int conceptID = 0, valueCoded = 0;
        String valueText = "";
        Date valueDate = null;
        double valueNumeric = 0.0;
        CodedSimpleType cst = null;
        if (!obsList.isEmpty()) {
            recencyTestResultType = new RecencyTestingType();
            for (Obs obs : obsList) {
                conceptID = obs.getConceptID();
                switch (conceptID) {
                    case 165849://HIV Recency Test Name (165849)
                        valueText = obs.getValueText();
                        recencyTestResultType.setTestName(valueText);
                        break;
                    case 165850://HIV Recency Test Date (165850)
                        valueDate = obs.getValueDate();
                        recencyTestResultType.setTestDate(Client.getXmlDate(valueDate));
                        break;
                    case 165853://Rapid recency assay (165853) 
                        valueCoded = obs.getValueCoded();
                        recencyTestResultType.setRapidRecencyAssay(getNDRCodedValue(valueCoded));
                        break;
                    case 165854://Sample test date (165854)
                        valueDate = obs.getValueDate();
                        recencyTestResultType.setViralLoadConfirmationTestDate(Client.getXmlDate(valueDate));
                        break;
                    case 856://HIV VIRAL LOAD (856)
                        valueNumeric = obs.getValueNumeric();
                        recencyTestResultType.setViralLoadConfirmationResult(String.valueOf(valueNumeric));
                        break;
                    case 165856://Final HIV recent infection testing algorithm result (165856)
                        valueCoded = obs.getValueCoded();
                        recencyTestResultType.setFinalRecencyTestResult(getNDRCodedValue(valueCoded));
                        break;
                    default:
                        break;
                }
            }
        }
        return recencyTestResultType;
    }

    public PostTestCounsellingType createPostTestCounsellingType(List<Obs> obsList, Demographics pts) {
        PostTestCounsellingType postTest = new PostTestCounsellingType();
        return postTest;
    }

    public IndexNotificationServicesType createIndexNotificationServices(List<Obs> obsList, Demographics pts) {
        IndexNotificationServicesType indexService = new IndexNotificationServicesType();
        return indexService;
    }

    public KnowledgeAssessmentType createKnowledgeAssessmentType(List<Obs> obsList, Demographics pts) {
        /*
           Previously tested HIV negative (165799)
           Client Pregnant (Test and ensure linkage to PMTCT Program)(1434) 	
           Client informed about HIV transmission routes (165801)	
           Client informed about risk factors for HIV transmission (165802)	
           Client informed on preventing HIV transmission methods (165804)	
           Client informed about possible test results 	(165884)
           Informed consent for HIV testing given (1710)
         */
        KnowledgeAssessmentType knowledgeAssessmentType = null;
        int conceptID = 0, valueCoded = 0;
        boolean ans = false;
        if (!obsList.isEmpty()) {
            knowledgeAssessmentType = new KnowledgeAssessmentType();
            for (Obs obs : obsList) {
                conceptID = obs.getConceptID();
                //valueCoded=obs.getValueCoded();
                switch (conceptID) {
                    case 165799://Previously tested HIV negative
                        valueCoded = obs.getValueCoded();
                        ans = convertYesNoValueCodedToBoolean(valueCoded);
                        knowledgeAssessmentType.setPreviouslyTestedHIVNegative(ans);
                        break;
                    case 1434://Client Pregnant (Test and ensure linkage to PMTCT Program)
                        valueCoded = obs.getValueCoded();
                        ans = convertYesNoValueCodedToBoolean(valueCoded);
                        knowledgeAssessmentType.setClientPregnant(ans);
                        break;
                    case 165801://Client informed about HIV transmission routes (165801)
                        valueCoded = obs.getValueCoded();
                        ans = convertYesNoValueCodedToBoolean(valueCoded);
                        knowledgeAssessmentType.setClientInformedAboutHIVTransmissionRoutes(ans);
                        break;
                    case 165802://Client informed about risk factors for HIV transmission
                        valueCoded = obs.getValueCoded();
                        ans = convertYesNoValueCodedToBoolean(valueCoded);
                        knowledgeAssessmentType.setClientInformedOfHIVTransmissionRiskFactors(ans);
                        break;
                    case 165804://Client informed on preventing HIV transmission methods
                        valueCoded = obs.getValueCoded();
                        ans = convertYesNoValueCodedToBoolean(valueCoded);
                        knowledgeAssessmentType.setClientInformedAboutPreventingHIV(ans);
                        break;
                    case 165884://Client informed about possible test results
                        valueCoded = obs.getValueCoded();
                        ans = convertYesNoValueCodedToBoolean(valueCoded);
                        knowledgeAssessmentType.setClientInformedAboutPossibleTestResults(ans);
                        break;
                    case 1710:// Informed consent for HIV testing given
                        valueCoded = obs.getValueCoded();
                        ans = convertYesNoValueCodedToBoolean(valueCoded);
                        knowledgeAssessmentType.setInformedConsentForHIVTestingGiven(ans);
                        break;
                    default:
                        break;

                }
            }
        }

        return knowledgeAssessmentType;
    }

    public HIVRiskAssessmentType createHIVRiskAssessmentType(List<Obs> obsList, Demographics pts) {
        /*
        //HIV Risk Assesment
 	Ever had sexual intercourse 165800	
 	
	Blood transfusion in last 3 months 1063	
	
	Unprotected sex with casual partner in last 3 months 159218	
	
	Unprotected sex with regular partner in the last 3 months 165803	
 	
	STI in last 3 months 164809	
 	
	More than 1 sex partner during last 3 months 165806	
         */
        HIVRiskAssessmentType hivRiskAssessmentType = null;
        int conceptID = 0, valueCoded = 0;
        boolean ans = false;
        if (!obsList.isEmpty()) {
            hivRiskAssessmentType = new HIVRiskAssessmentType();
            for (Obs obs : obsList) {
                conceptID = obs.getConceptID();
                switch (conceptID) {
                    case 165800://Ever had sexual intercourse
                        valueCoded = obs.getValueCoded();
                        ans = convertYesNoValueCodedToBoolean(valueCoded);
                        hivRiskAssessmentType.setEverHadSexualIntercourse(ans);
                        break;
                    case 1063://Blood transfusion in last 3 months
                        valueCoded = obs.getValueCoded();
                        ans = convertYesNoValueCodedToBoolean(valueCoded);
                        hivRiskAssessmentType.setBloodTransfussionInLast3Months(ans);
                        break;
                    case 159218: //Unprotected sex with casual partner in last 3 months 
                        valueCoded = obs.getValueCoded();
                        ans = convertYesNoValueCodedToBoolean(valueCoded);
                        hivRiskAssessmentType.setUnprotectedSexWithCasualPartnerinLast3Months(ans);
                        break;
                    case 165803://Unprotected sex with regular partner in the last 3 months
                        valueCoded = obs.getValueCoded();
                        ans = convertYesNoValueCodedToBoolean(valueCoded);
                        hivRiskAssessmentType.setUnprotectedSexWithRegularPartnerInLast3Months(ans);
                        break;
                    case 164809://STI in last 3 months
                        valueCoded = obs.getValueCoded();
                        ans = convertYesNoValueCodedToBoolean(valueCoded);
                        hivRiskAssessmentType.setSTIInLast3Months(ans);
                        break;
                    case 165806://More than 1 sex partner during last 3 months
                        valueCoded = obs.getValueCoded();
                        ans = convertYesNoValueCodedToBoolean(valueCoded);
                        hivRiskAssessmentType.setMoreThan1SexPartnerDuringLast3Months(ans);
                        break;
                    default:
                        break;
                }
            }
        }
        return hivRiskAssessmentType;
    }

    public ClinicalTBScreeningType createClinicalTBScreeningType(List<Obs> obsList, Demographics demo) {
        /*
           //Client TB Screening 	
           Current Cough 143264) 		
           Weight Loss (832)	
           Fever (140238)	
           Night sweats (133027) 		
           Contact with TB+ patient (124068) 		
           TB Screening Score  (165808) 	
         */
        ClinicalTBScreeningType clinicalTBScreeningType = null;
        int conceptID = 0, valueCoded = 0;
        boolean ans = false;
        if (!obsList.isEmpty()) {
            clinicalTBScreeningType = new ClinicalTBScreeningType();
            for (Obs obs : obsList) {
                conceptID = obs.getConceptID();
                switch (conceptID) {
                    case 143264://Current Cough 143264 
                        valueCoded = obs.getValueCoded();
                        ans = convertYesNoValueCodedToBoolean(valueCoded);
                        clinicalTBScreeningType.setCurrentlyCough(ans);
                        break;
                    case 832://Weight Loss 
                        valueCoded = obs.getValueCoded();
                        ans = convertYesNoValueCodedToBoolean(valueCoded);
                        clinicalTBScreeningType.setWeightLoss(ans);
                        break;
                    case 140238://Fever (140238)
                        valueCoded = obs.getValueCoded();
                        ans = convertYesNoValueCodedToBoolean(valueCoded);
                        clinicalTBScreeningType.setFever(ans);
                        break;
                    case 133027://Night sweats (133027)
                        valueCoded = obs.getValueCoded();
                        ans = convertYesNoValueCodedToBoolean(valueCoded);
                        clinicalTBScreeningType.setNightSweats(ans);
                        break;
                    default:
                        break;
                }
            }
        }
        return clinicalTBScreeningType;
    }

    public SyndromicSTIScreeningType createSyndromicSTIScreeningType(List<Obs> obsList, Demographics demo) {
        /*
            Syndromic STI Screening
            Complaints of vaginal discharge or burning when urinating? (165809) 	
            Complaints of lower abdominal pains with or without vaginal discharge (165810) 	 	
            Complaints of genital sore(s) or swollen inguinal lymph nodes with or without pains (165813) 		
            Complaints of scrotal swelling and pain (165812)
         */
        SyndromicSTIScreeningType syndromicSTIScreeningType = null;
        int conceptID = 0, valueCoded = 0;
        boolean ans = false;
        if (!obsList.isEmpty()) {
            syndromicSTIScreeningType = new SyndromicSTIScreeningType();
            for (Obs obs : obsList) {
                conceptID = obs.getConceptID();
                switch (conceptID) {
                    case 165809://Complaints of vaginal discharge or burning when urinating? (165809)
                        valueCoded = obs.getValueCoded();
                        ans = convertYesNoValueCodedToBoolean(valueCoded);
                        syndromicSTIScreeningType.setVaginalDischargeOrBurningWhenUrinating(ans);
                        break;
                    case 165810://Complaints of lower abdominal pains with or without vaginal discharge (165810)
                        valueCoded = obs.getValueCoded();
                        ans = convertYesNoValueCodedToBoolean(valueCoded);
                        syndromicSTIScreeningType.setLowerAbdominalPainsWithOrWithoutVaginalDischarge(ans);
                        break;
                    case 165813://Complaints of genital sore(s) or swollen inguinal lymph nodes with or without pains (165813)
                        valueCoded = obs.getValueCoded();
                        ans = convertYesNoValueCodedToBoolean(valueCoded);
                        syndromicSTIScreeningType.setGenitalSoreOrSwollenInguinalLymphNodes(ans);
                        break;
                    case 165812://Complaints of scrotal swelling and pain
                        valueCoded = obs.getValueCoded();
                        ans = convertYesNoValueCodedToBoolean(valueCoded);
                        syndromicSTIScreeningType.setScrotalSwellingAndPain(ans);
                        break;
                    default:
                        break;
                }
            }
        }
        return syndromicSTIScreeningType;
    }

}
