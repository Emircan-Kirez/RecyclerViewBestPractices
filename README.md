# Best Practices
- Create interface for clickListeners
- Assign clickListeners with init block inside Viewholder not inside onBindViewHolder because onBindViewHolder works constantly to show new information but onCreateView works to generate enough viewHolders.
- Implement the interface where you would use recyclerView and pass it as parameter to adapter