//package example7;
//
//public class Main {
//    public static void main(String[] args) {
//
//    }
//
//    public static String renderPageWithSetupsAndTearDowns(PageData pageData, boolean isSuite) {
//        if (isTestPage(pageData)) {
//            includeSetupAndTearDownPages(pageData, isSuite);
//        }
//        return pageData.getHtml();
//    }
//
//    public static class UserValidator {
//        private Cryptographer cryptographer;
//
//        public boolean checkPassword(String userName, String password) {
//            User user = UserGateway.findByName(userName);
//            if(user != User.NULL) {
//                String codePhrase = user.getPhraseEncodedByPassword();
//                String phrase = cryptographer.decrypt(codePhrase, password);
//                if("Valid Password".equals(phrase)) {
//                    Session.initialize();
//                    return true;
//                }
//            }
//            return false;
//        }
//    }
//}
//
