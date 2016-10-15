package models

import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class ClientError(error: String)

case class Question(
                     topic: String,
                     preview: Option[String],
                     text: String,
                     ages: Seq[Int],
                     answers: Seq[Answer]
                   )

case class Answer(
                  id: String,
                  text: String
                 )

case class ClientAnsweredQuestion(
                                   question: String,
                                   answer: String
                                 )

case class ClientEndOfGame(
                      causeOfDeath: String,
                      probability: String,
                      highScore: Int
                    )

case class GameState(
                      gameId: String,
                      age: Int,
                      money: Int,
                      satisfaction: Int,
                      lastAnswers: Seq[ClientAnsweredQuestion],
                      endOfGame: Option[ClientEndOfGame]
                    )

trait ClientModel {

  implicit val ClientErrorFormat = Json.format[ClientError]
  implicit val ClientEndOfGameFormat = Json.format[ClientEndOfGame]
  implicit val AnswerFormat = Json.format[Answer]
  implicit val QuestionFormat = Json.format[Question]
  implicit val ClientAnsweredQuestionFormat = Json.format[ClientAnsweredQuestion]
  implicit val GameStateFormat = Json.format[GameState]
}