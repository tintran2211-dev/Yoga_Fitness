package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bt2.R;

import My_Interface.Interface;
import Object.User;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<User> userList;
    private Interface anInterface;
    public Adapter(List<User> userList,Interface listener) {
        this.userList = userList;
        this.anInterface = listener;
    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //tạo 1 biến View chuyển layout file xml thành view javacode
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item1,parent,false);

        //return ra viewholder với biến view được tạo
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        final User user = userList.get(position);

        holder.textView.setText(user.getTieude());
        holder.imageView.setImageResource(user.getAnh());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anInterface.onclick(user);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        private RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img1_item);
            textView  = itemView.findViewById(R.id.txt1_item);
            relativeLayout = itemView.findViewById(R.id.layout_item1);
        }

    }
}
