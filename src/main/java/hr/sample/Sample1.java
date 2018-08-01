package hr.sample;

public class Sample1 {
	public static void main(String[] args) {
		String str = "https://api.github.com/repos/HirabayashiOrg/heroku-java-app/commits{/sha}";
		System.out.println(str);

		str = str.replaceAll("\\{.*\\}", "");

		System.out.println(str);
	}
}
