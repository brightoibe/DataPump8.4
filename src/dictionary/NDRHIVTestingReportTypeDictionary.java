/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.HashMap;
import java.util.Map;

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
    private Map<Integer,String> ndrCodingMap=new HashMap<Integer,String>();
    public NDRHIVTestingReportTypeDictionary(){
        
    }
    public void loadDictionary(){
        
    }
    
}
