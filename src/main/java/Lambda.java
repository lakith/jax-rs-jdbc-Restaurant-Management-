interface Going{
    void runner();
}
class Running {
    public void lamb(Going g) {
        System.out.println("ok its starting...");
        g.runner();
    }
}
    public class Lambda {
        public static void main(String[] arg) {
            /*
            ////////////////////////////////////////////////////////////////////////////
            // whrn using lambda in anonyms classes,before 8 and using lambda
            ////////////////////////////////////////////////////////////////////////////
            Running running = new Running();
            running.lamb(new Going() {
                @Override
                public void runner() {
                    System.out.println("this is runner");
                }
            });
            running.lamb(() -> System.out.println("asdasd"));*/
            ///////////////////////////////////////////////////////////////////////////////

            Going go=()-> System.out.println("yanawoo");
            go.runner();
        }
    }

