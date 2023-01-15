function checkPassword() {
    let password = document.getElementById("password");
    let confirm = document.getElementById("confirm");
    if(password. password.value !== confirm.value) {
        confirm.value = "";
        alert("Passwords don't match");
    }
}


function addQuestion() {
    let questionNumber = document.getElementsByClassName("question").length;
    let question = document.createElement("div");
    question.className = "question";
    question.innerHTML = `<label>Question number: <input type=\"number\" required id=\"questions${questionNumber}.number\" name=\"questions[${questionNumber}].number\" value=\"${questionNumber+1}\"> </label> <label>Content: <textarea required=\"\" id=\"questions${questionNumber}.content\" name=\"questions[${questionNumber}].content\"></textarea> </label> <label>Question score: <input type=\"number\" required id=\"questions${questionNumber}.score\" name=\"questions[${questionNumber}].score\"> </label> <p>Mark the correct answers:</p> <div id="answerButtons${questionNumber}"> <input type="button" onclick="addAnswer(${questionNumber})" value="Add new answer"> <input type="button" onclick="deleteLastAnswer(${questionNumber})" value="Delete last answer"> </div>`;

    let submitButton = document.getElementById("questionButtons");
    submitButton.before(question);
}

function deleteLastQuestion() {
    let questions = document.getElementsByClassName("question");
    let lastQuestionNumber = document.getElementsByClassName("question").length;
    let lastQuestion = questions.item(lastQuestionNumber - 1);
    lastQuestion.remove();
}


function addAnswer(questionNumber) {
    let answerButtons = document.getElementById(`answerButtons${questionNumber}`);
    let countAnswers = answerButtons.parentElement.getElementsByClassName("answer").length;
    let answer = document.createElement("div");
    answer.className = "answer";
    answer.innerHTML = `<label>Answer content: <input type="checkbox" value="true" name="questions[${questionNumber}].answers[${countAnswers}].correct"> <textarea name="questions[${questionNumber}].answers[${countAnswers}].content"></textarea> </label>`;
    answerButtons.before(answer);
}

function deleteLastAnswer(questionNumber) {
    let lastAnswerNumber = document.getElementsByClassName("question").item(questionNumber).getElementsByClassName("answer");
    let lastAnswer = document.getElementsByClassName("question").item(questionNumber).getElementsByClassName("answer").item(lastAnswerNumber - 1);
    lastAnswer.remove();
}