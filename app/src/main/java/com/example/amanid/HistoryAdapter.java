package com.example.amanid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amanid.databinding.HistoryItemBinding;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends ListAdapter<HistoryModel,HistoryAdapter.HistoryViewHolder> {
    private List<HistoryModel> originalList;
    public void setOriginalList(List<HistoryModel> originalList) {
        this.originalList = originalList;
    }

    // Create a filter method to perform search
    public void filter(String searchText) {
        List<HistoryModel> filteredList = new ArrayList<>();
        if (originalList != null) {
            for (HistoryModel model : originalList) {
                if (model.getName().toLowerCase().contains(searchText.toLowerCase())) {
                    filteredList.add(model);
                }
            }
        }
        submitList(filteredList);
    }
    public static final DiffUtil.ItemCallback<HistoryModel> CALLBACK=new DiffUtil.ItemCallback<HistoryModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull HistoryModel oldItem, @NonNull HistoryModel newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull HistoryModel oldItem, @NonNull HistoryModel newItem) {
            return false;
        }
    };

    public HistoryAdapter(){
        super(CALLBACK);
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {

        HistoryModel model=getItem(position);
        holder.binding.customerName.setText(model.getName());
        holder.binding.email.setText(model.getAmount());

    }

    class HistoryViewHolder extends RecyclerView.ViewHolder{
        public HistoryItemBinding binding;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=HistoryItemBinding.bind(itemView);
        }
    }
}
