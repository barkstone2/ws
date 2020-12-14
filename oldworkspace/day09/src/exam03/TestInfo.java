package exam03;
enum TestType{FIRST,FINAL}

public @interface TestInfo {
	int count();
	String testedBy();
	String[] testTools();
	TestType testType();
	DateTime testDate();
}
@interface DateTime{
	String yymmdd();
	String hhmmss();
}