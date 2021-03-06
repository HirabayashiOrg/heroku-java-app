package hr.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CommitUtilTest {
	@Rule
	public ExpectedException exceptedException = ExpectedException.none();

	@Test
	public void GitAPI確認() throws Exception  {
		URL url = new URL("https://api.github.com/repos/HirabayashiOrg/heroku-java-app/commits/1121dc98e32bdea93112ff5249f7612890e3543c");
		URLConnection con = url.openConnection();

		con.setDoInput(true);
		InputStream is = con.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String str = "";
		String line = "";
		while((line = br.readLine()) != null) {
			str += line;
		}

		System.out.println(str);
	}
}

