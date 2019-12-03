package epsi.fr.applicationtitre;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Remi on 21/06/2019.
 */

public class TaskInfoAdapter extends ArrayAdapter<Task> {
    private Activity context;
    private List<Task> tasks;

    public TaskInfoAdapter(Activity context, List<Task> tasks){
        super(context, R.layout.view, tasks);
        this.context = context;
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listView = inflater.inflate(R.layout.view, null, true);

        TextView taskName = (TextView)listView.findViewById(R.id.nom);
        TextView taskDate = (TextView)listView.findViewById(R.id.date);

        Task task = tasks.get(position);
        taskName.setText(task.getNom());
        taskDate.setText(task.getDateAttribution());

        return listView;
    }
}
