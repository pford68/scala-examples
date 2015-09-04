package com.macedon.scala.examples.twitter
import twitter4j.TwitterFactory
import twitter4j.Twitter
import twitter4j.conf.ConfigurationBuilder
import java.util.Properties
import java.io.FileInputStream


object ScalaTwitterClientExample {
   
  def main(args : Array[String]) {

    val (key, secret, token, secretToken) =
      try {
        val prop = new Properties()
        prop.load(ScalaTwitterClientExample.getClass.getClassLoader.getResourceAsStream("auth.properties"))

        (
          prop.getProperty("consumer.key"),
          prop.getProperty("consumer.secret"),
          prop.getProperty("access.token"),
          prop.getProperty("access.token.secret")
          )
      } catch { case e: Exception =>
        e.printStackTrace()
        sys.exit(1)
      }


    // (1) config work to create a twitter object
    val cb = new ConfigurationBuilder()
    cb.setDebugEnabled(true)
      .setOAuthConsumerKey(key)
      .setOAuthConsumerSecret(secret)
      .setOAuthAccessToken(token)
      .setOAuthAccessTokenSecret(secretToken)
    val tf = new TwitterFactory(cb.build())
    val twitter = tf.getInstance()

    println(s"Twitter:  $twitter")
 
    // (2) use the twitter object to get your friend's timeline
    val statuses = twitter.getHomeTimeline
    System.out.println("Showing friends timeline.")
    val it = statuses.iterator()
    while (it.hasNext) {
      val status = it.next()
      println(status.getUser.getName + ":" + status.getText)
    }

  }

}