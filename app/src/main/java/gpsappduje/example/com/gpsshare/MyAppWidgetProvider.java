package gpsappduje.example.com.gpsshare;


        import java.util.Random;

        import android.app.PendingIntent;
        import android.appwidget.AppWidgetManager;
        import android.appwidget.AppWidgetProvider;
        import android.content.ComponentName;
        import android.content.Context;
        import android.content.Intent;
        import android.net.Uri;
        import android.util.Log;
        import android.widget.RemoteViews;

public class MyAppWidgetProvider extends AppWidgetProvider {

    private static final String ACTION_CLICK = "ACTION_CLICK";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {

        super.onUpdate(context, appWidgetManager, appWidgetIds);

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
        // When we click the widget, we want to open our main activity.
        Intent launchActivity = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, launchActivity, 0);
        remoteViews.setOnClickPendingIntent(R.id.update, pendingIntent);;

        ComponentName thisWidget = new ComponentName(context, MyAppWidgetProvider.class);
        AppWidgetManager manager = AppWidgetManager.getInstance(context);
        manager.updateAppWidget(thisWidget, remoteViews);

    }
}