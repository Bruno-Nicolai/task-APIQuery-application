package bruno.nicolai.app_api_query.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import bruno.nicolai.app_api_query.R;
import bruno.nicolai.app_api_query.models.User;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private List<User> usersList;

    public UsersAdapter(List<User> usersListList) {
        this.usersList = usersListList;
    }

    @NonNull
    @Override
    public UsersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.ViewHolder holder, int position) {
        User user = usersList.get(position);
        ((TextView) holder.view.findViewById(R.id.tv_name_user)).setText(user.getName());
        ((TextView) holder.view.findViewById(R.id.tv_username_user)).setText(user.getUserName());
        ((TextView) holder.view.findViewById(R.id.tv_email_user)).setText(user.getEmail());
        ((TextView) holder.view.findViewById(R.id.tv_phone_user)).setText(user.getPhone());
        ((TextView) holder.view.findViewById(R.id.tv_website_user)).setText(user.getWebsite());
        ((TextView) holder.view.findViewById(R.id.tv_address_street_user)).setText(user.getAddress().getStreet());
        ((TextView) holder.view.findViewById(R.id.tv_address_city_user)).setText(user.getAddress().getCity());
    }

    public void sortUsers(User.SortOrder sortOrder) {
        switch (sortOrder) {
            case ASCENDING:
                sortByAscendingName();
                break;
            case DESCENDING:
                sortByDescendingName();
                break;
            case DEFAULT:
            default:
                break;
        }
    }


    public void sortByAscendingName() {
        Collections.sort(usersList, new User.UserNameComparator());
        notifyDataSetChanged();
    }

    public void sortByDescendingName() {
        Collections.sort(usersList, Collections.reverseOrder(new User.UserNameComparator()));
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.view = itemView;
        }
    }
}
