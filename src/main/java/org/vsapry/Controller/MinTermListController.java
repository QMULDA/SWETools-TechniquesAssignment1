    package org.vsapry.Controller;

    import java.util.Set;
    import org.vsapry.Model.MinTermList;

    public class MinTermListController {

        private MinTermList model;

        public MinTermListController(MinTermList model) {
            this.model = model;
        }

        public Set<String> getMin(){
            return model.getMin();
        }

        public void setMinList(String x){
            model.setMinList(x);
        }



    }
