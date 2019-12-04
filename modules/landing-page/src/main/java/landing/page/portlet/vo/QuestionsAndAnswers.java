package landing.page.portlet.vo;

public class QuestionsAndAnswers {
	String id;
	String question;
	String answer;
	String questionAr;
	String answerAr;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getQuestionAr() {
		return questionAr ==null ||questionAr.equalsIgnoreCase("null") || questionAr.equalsIgnoreCase("")?question:questionAr;
	}
	public void setQuestionAr(String questionAr) {
		this.questionAr = questionAr;
	}
	public String getAnswerAr() {
		return answerAr ==null ||answerAr.equalsIgnoreCase("null") || answerAr.equalsIgnoreCase("")?answer:answerAr;
	}
	public void setAnswerAr(String answerAr) {
		this.answerAr = answerAr;
	}

}
