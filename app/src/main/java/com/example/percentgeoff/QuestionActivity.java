package com.example.percentgeoff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    static List<Question> questions = new ArrayList<>();
    int score;
    int maxScore = 0;

    Button first;
    Button second;
    Button third;
    Button fourth;

    int questionNumber;

    TextView questionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        setUpQuestions();

        questionNumber = 0;
        score = 0;
        maxScore = 0;

        List<String> answers = questions.get(questionNumber).getAnswers();

        Log.d("tag", "didn't end, question: " + questionNumber + ", array size: " + questions.size());

        first = findViewById(R.id.answer);
        second = findViewById(R.id.answer1);
        third = findViewById(R.id.answer2);
        fourth = findViewById(R.id.answer3);
        questionText = findViewById(R.id.questionText);

        rewrite();

        first.setOnClickListener(unused -> {
            maxScore += 3;
            questionNumber++;
            rewrite();
        });
        second.setOnClickListener(unused -> {
            score += 1;
            maxScore += 3;
            questionNumber++;
            rewrite();
        });
        third.setOnClickListener(unused -> {
            score += 2;
            maxScore += 3;
            questionNumber++;
            rewrite();
        });
        fourth.setOnClickListener(unused -> {
            score += 3;
            maxScore += 3;
            questionNumber++;
            rewrite();
        });
    }

    /**
     * sets up the questions. ~~my javadoc is so good~~
     */
    public void setUpQuestions() {

        List<String> firstAnswers = new ArrayList<>();
        firstAnswers.add("Python");
        firstAnswers.add("Other");
        firstAnswers.add("Java");
        firstAnswers.add("Kotlin");
        Question firstQuestion = new Question("What's your favorite language?", firstAnswers);
        questions.add(firstQuestion);

        List<String> secondAnswers = new ArrayList<>();
        secondAnswers.add("I like it, honestly");
        secondAnswers.add("It's okay, I guess");
        secondAnswers.add("Really don't like it");
        secondAnswers.add("It murdered my wife, cat, and dog");
        Question secondQuestion = new Question("What are your feelings on Microsoft Office?", secondAnswers);
        questions.add(secondQuestion);

        List<String> thirdAnswers = new ArrayList<>();
        thirdAnswers.add("We should all be worshipping it");
        thirdAnswers.add("I like it");
        thirdAnswers.add("I dislike it");
        thirdAnswers.add("How do you even copy and paste?");
        Question thirdQuestion = new Question("What are your feelings on Windows?", thirdAnswers);
        questions.add(thirdQuestion);

        List<String> fourthAnswers = new ArrayList<>();
        fourthAnswers.add("Formal Attire");
        fourthAnswers.add("Ripped Jeans");
        fourthAnswers.add("An intimidatingly sized baseball cap");
        fourthAnswers.add("The tears of student’s cries for help on the MP");
        Question fourthQuestion = new Question("What would you wear to a CS class on a warm sunny day in Champaign?", fourthAnswers);
        questions.add(fourthQuestion);

        List<String> fifthAnswers = new ArrayList<>();
        fifthAnswers.add("11 pipers piping");
        fifthAnswers.add("11 Checkstyle errors");
        fifthAnswers.add("11 Machine Projects");
        fifthAnswers.add("Not enough TA’s for office hours");
        Question fifthQuestion = new Question("On the 11th day of christmas my true love gave to me...", fifthAnswers);
        questions.add(fifthQuestion);

        List<String> sixthAnswers = new ArrayList<>();
        sixthAnswers.add("ArrayList list = new ArrayList<>();");
        sixthAnswers.add("LinkedList list = new LinkedList<>();");
        sixthAnswers.add("List list = new ArrayList<>();");
        sixthAnswers.add("List list = new LinkedList<>();");
        Question sixthQuestion = new Question("What’s your favorite way to declare a List in Java?", sixthAnswers);
        questions.add(sixthQuestion);

        List<String> seventhAnswers = new ArrayList<>();
        seventhAnswers.add("Piazza");
        seventhAnswers.add("Queue");
        seventhAnswers.add("Forum");
        seventhAnswers.add("Office Hours");
        Question seventhQuestion = new Question("What’s your favorite platform for students to get help on assignments?", seventhAnswers);
        questions.add(seventhQuestion);

        List<String> eighthAnswers = new ArrayList<>();
        eighthAnswers.add("Make memes");
        eighthAnswers.add("Write Reddit Posts");
        eighthAnswers.add("Talk about the issue");
        eighthAnswers.add("Join scientista");
        Question eighthQuestion = new Question("What would you do if you wanted to do more than tweet about diversity?", eighthAnswers);
        questions.add(eighthQuestion);

        List<String> ninthAnswers = new ArrayList<>();
        ninthAnswers.add("Very small, twenty people or less");
        ninthAnswers.add("Average sized, with maybe a few hundred or less");
        ninthAnswers.add("Pretty big, maybe almost a thousand");
        ninthAnswers.add("Huge! As many as can fit in UIUC’s basketball stadium");
        Question ninthQuestion = new Question("If you were a teacher, what would your ideal class size be?", ninthAnswers);
        questions.add(ninthQuestion);

        List<String> tenthAnswers = new ArrayList<>();
        tenthAnswers.add("Emacs");
        tenthAnswers.add("Microsoft Word");
        tenthAnswers.add("Google Docs");
        tenthAnswers.add("Vim");
        Question tenthQuestion = new Question("What’s your favorite Text Editor?", tenthAnswers);
        questions.add(tenthQuestion);

    }


    public void end() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("maxScore", maxScore);
        intent.putExtra("score", score);
        startActivity(intent);
        finish();
    }

    public void rewrite() {
        if (questionNumber >= questions.size()) {
            end();
        }

        try {
            Question current = questions.get(questionNumber);
            questionText.setText(current.getQuestion());
            first.setText(current.getAnswers().get(0));
            second.setText(current.getAnswers().get(1));
            third.setText(current.getAnswers().get(2));
            fourth.setText(current.getAnswers().get(3));
        }
        catch(Exception e) {
            questionText.setText("error :(");
        }

    }
}
