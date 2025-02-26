    package org.vsapry.Controller;

    import java.util.Set;
    import org.vsapry.Model.MinTermList;
    import org.vsapry.Model.MinTerm;

    public class MinTermListController {

        private MinTermList model;

        public static Set<String> getMin(){
            return MinTermList.getMin();
        }

        public void setMinList(String x){
            model.setMinList(x);
        }

        public MinTermListController(MinTermList model) {
            this.model = model;
        }

    }
