package com.singleton;

public class Singleton {

    private static Singleton INSTANCE = null;

    private Singleton() {
        //צריכה להיות private כדי למנוע גישה לקונסטרקטור
    }

    public static Singleton getInstance() {
        return createInstance();
    }

    private static Singleton createInstance() {
        if (INSTANCE == null) { // בכדי לחסוך תהליך המתנת הthreads בשורה 17 כי זה מייצר עומס מבחינת הביצוע
            synchronized (Singleton.class) {
                //הבעייה היא שביישומים מרובי תהליכונים (multi-threaded applications) יש להיזהר במימוש התבנית.
                // אם שני תהליכונים ניגשים לפונקצייה באותו הזמן,
                // ייתכן מצב בו שניהם ייצרו מופע וזה בניגוד לחוק הsingleton שחייב לייצר רק מופע אחד למחלקה
                //בכדי למנוע המצה הזה, צריך לנעול הקטע קוד באמצעות שימוש בsynchronized שימנע כניסת יותר מthread אחד
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

    // private static Singleton createInstance() {
    // if (INSTANCE == null)
    // INSTANCE = new Singleton();
    // return INSTANCE;
    //}
    // המצב הזה יהיה תקין רק אם יש לתוכנית thread אחד ויחיד ואז בוודאות לאיהיה מצב שייצרו יותר ממופע אחד
}


