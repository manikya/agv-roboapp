package lk.kadiya.test.apitestautomation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @GetMapping(path = "/openChat")
    public ResponseEntity<String> openVideo(@RequestParam(value = "url") String url) {
        System.out.println("Value Received " + url);
        open(url);
        return ResponseEntity.ok("success");
    }

    @GetMapping(path = "/closeChat")
    public ResponseEntity<String> closeVideo() {
        System.out.println("Value Received for close browser" );
        close();
        return ResponseEntity.ok("success");
    }

    private void close() {
        String os = System.getProperty("os.name").toLowerCase();
        Runtime rt = Runtime.getRuntime();

        try{

            if (os.indexOf( "win" ) >= 0) {

                // this doesn't support showing urls in the form of "page.html#nameLink"
//                rt.exec( "rundll32 url.dll,FileProtocolHandler " );

            } else if (os.indexOf( "mac" ) >= 0) {

//                rt.exec( "open " + url);

            } else if (os.indexOf( "nix") >=0 || os.indexOf( "nux") >=0) {

                String cmd = "pkill -o chromium";
                rt.exec(new String[] { "sh", "-c", cmd });

            } else {
                return;
            }
        }catch (Exception e){
            return;
        }
        return;

    }

    private  static void open ( String url){
        String os = System.getProperty("os.name").toLowerCase();
        Runtime rt = Runtime.getRuntime();

        try{

            if (os.indexOf( "win" ) >= 0) {

                // this doesn't support showing urls in the form of "page.html#nameLink"
                rt.exec( "rundll32 url.dll,FileProtocolHandler " + url);

            } else if (os.indexOf( "mac" ) >= 0) {

                rt.exec( "open " + url);

            } else if (os.indexOf( "nix") >=0 || os.indexOf( "nux") >=0) {

                // Do a best guess on unix until we get a platform independent way
                // Build a list of browsers to try, in this order.
                String[] browsers = {"chromium-browser"};

                // Build a command string which looks like "browser1 "url" || browser2 "url" ||..."
                StringBuffer cmd = new StringBuffer();
                for (int i=0; i<browsers.length; i++)
                    cmd.append( (i==0  ? "" : " || " ) + browsers[i] +" \"" + url + "\" ");
                System.out.println(cmd.toString());
                rt.exec(new String[] { "sh", "-c", cmd.toString() });

            } else {
                return;
            }
        }catch (Exception e){
            return;
        }
        return;
    }

    public static boolean isWindowsPlatform() {
        String os = System.getProperty("os.name");
        return os != null && os.startsWith("Windows");
    }
}
