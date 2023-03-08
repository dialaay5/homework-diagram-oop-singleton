package com.singleton;

public class Singleton {

    private static Singleton INSTANCE = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        return createInstance();
    }

    private static Singleton createInstance() {
        if (INSTANCE == null) { // בכדי לחסוך תהליך המתנת התהליכונים בשורה 16 כי זה מייצר עומס מבחינת הביצוע
            synchronized (Singleton.class) {
                //הבעייה היא שביישומים מרובי תהליכונים (multi-threaded applications) יש להיזהר במימוש התבנית.
                // אם שני תהליכונים ניגשים לפונקצייה באותו הזמן,
                // ייתכן מצב בו שניהם ייצרו מופע וזה בניגוד לחוק הסינגלטון שחייב לייצר רק מופע אחד למחלקה
                //בכדי למנוע המצה הזה, צריך לנעול הקטע קוד באמצעות שימוש בסינכרוניזד שימנע כניסת יותר תהליכון אחד
                if (INSTANCE == null) {
                    // יש צורך בבדיקה השנייה מכיוון ששרשורים רבים מתנהלים דרך הקוד הזה ואולי שרשור אחר כבר השיג את הנעילה והצליח לאתחל את המופע.
                    // במקרה זה, המופע יהיה נוכח ואין לאתחל אותו.
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
    // המצב הזה יהיה תקין רק אם יש לתוכנית תהליכון אחד ויחיד ואז בוודאות לאיהיה מצב שייצרו יותר ממופע אחד
}


