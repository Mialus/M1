/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samptd10;

/**
 *
 * @author Pierre
 */
public class SampTd10 {
/*
    OCL : Context:Article
    inv: self.evaluation->size()=3
    and
    self.evaluation->exists(s : Scientifique| s : theme = self.theme))
    
    Q4:
    Context:ComiteProgramme
    inv: self.membres->size()=20
    and
    self.membres->collects(nationalite)->asSet()->size()>10
       
    Q5:
    context Article
    inv:
    self.evaluateurs->excludesAll(self.auteurs)
    self.evaluateurs->forAll(s.Scientifique)
    
    Q6:Context Article
    inv: self.evaluateurs->forAll(s:Scientifique|self.auteurs->forAll(a:Scientifique|a.institution!=s.institution))
    
    exercice 3
*/
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
