function checkPassword() {
    let password = document.getElementById("password");
    let confirm = document.getElementById("confirm");
    if(password. password.value !== confirm.value) {
        confirm.value = "";
        alert("Passwords don't match");
    }
}

function addQuestion() {
    let questionNumber = document.getElementsByClassName("question").length + 1;
    let question = document.createElement("div");
    question.className = "question";
    question.innerHTML = `<label>Question number: <input type=\"number\" required id=\"questions${questionNumber}.number\" name=\"questions[${questionNumber}].number\" value=\"${questionNumber}\"> </label> <label>Content: <textarea required=\"\" id=\"questions${questionNumber}.content\" name=\"questions[${questionNumber}].content\"></textarea> </label> <label>Question score: <input type=\"number\" required id=\"questions${questionNumber}.score\" name=\"questions[${questionNumber}].score\"> </label>`;

    if(questionNumber !== 1) {
        let previousQuestion = document.getElementsByClassName("question").item(questionNumber - 2);
        previousQuestion.after(question);
    }
    else {
        let form = document.getElementById("title");
        form.after(question);
    }
}

function deleteLastQuestion() {
    let questions = document.getElementsByClassName("question");
    let lastQuestionNumber = document.getElementsByClassName("question").length;
    let lastQuestion = questions.item(lastQuestionNumber - 1);
    lastQuestion.remove();
}