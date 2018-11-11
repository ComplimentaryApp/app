package com.example.nicolas.komplimente


import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import java.util.Random


/**
 * A simple [Fragment] subclass.
 */
class Compliment : Fragment() {

    internal var mood: Int = 0
    internal var adjective: Int = 0

    internal lateinit var back: ImageView
    internal lateinit var quote: TextView

    internal lateinit var constraintLayout: ConstraintLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_compliment, container, false)
        mood = arguments!!.getInt("mood")
        adjective = arguments!!.getInt("adjective")
        back = view.findViewById<View>(R.id.back) as ImageView
        quote = view.findViewById<View>(R.id.quote) as TextView
        constraintLayout = view.findViewById(R.id.compliment_constraint)
        val images = listOf(
            R.drawable.backgrounds001,
            R.drawable.backgrounds002,
            R.drawable.backgrounds003,
            R.drawable.backgrounds004,
            R.drawable.backgrounds005,
            R.drawable.backgrounds006,
            R.drawable.backgrounds007,
            R.drawable.backgrounds008,
            R.drawable.backgrounds009,
            R.drawable.backgrounds010
        )
        val rand = Random()
        back.setImageResource(images[rand.nextInt(images.size)])
        val genericCompliments = arrayOf(
            "When you are not afraid to be yourself, that's when you're the most incredible",
            "Thousands of candles can be lighted from a single candle, and the life of the candle will not be shortened. Happiness never decreases by being shared. -Buddha",
            "You always find a way to see the best in people. It inspires me to be more positive and considerate. Thank you.",
            "I notice the ways you love me in the little things you do. From baking me scones to hand-made birthday cards, your actions speak a lot.",
            "You are always happy to go out of your way to help others. I do not know anyone who is as generous with his or her time or energy as you.",
            "One of the best things in life is to feel understood. You are such an extremely empathetic person. I feel like I can tell you everything without fear of judgement and with assured hopes of being understood.",
            "Thank you for being my yes-person. I can always count on you for support of my ideas and decisions.",
            "You are a fantastic baker. Eating your sweet treats makes me feel the love inside - yummy in my tummy!",
            "The other night we stayed up chatting and eating ice cream until 3 a.m. I appreciate the long, diverse, and deep discussions we effortlessly have. Thank you for pushing my minds and opinions in new directions. Food for thought is the most delicious thing.",
            "I respect the way present and found your opinions. You always discuss respectfully and are a great listener. Engaging conversations with you bring joy to my days!",
            "I loved going to the Neue Pinakothek with you the other weekend. Making up stories about the paintings, or simply discussing the random trains of thought the art inspired, made me laugh plenty and appreciate more the ways in which your brain works, and what a lovely thing it is. :)",
            "I know that if I ever need a hug, no matter the reason, I can walk up to you without an explanation, open my arms, and I know you will wrap me in a cocoon of warmth and safety."
        )
        quote.text = if (compliments.size == 0) genericCompliments[rand.nextInt(genericCompliments.size)]
            else compliments[rand.nextInt(compliments.size)].body

        constraintLayout.setOnClickListener {
            Toast.makeText(context, "IT WORKS !!!", Toast.LENGTH_SHORT).show()
        }
        return view
    }

    companion object {
        var compliments = ArrayList<ComplimentMessage>()
    }
}

