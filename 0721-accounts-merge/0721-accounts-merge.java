import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Map email to the account index it first appeared in
        Map<String, Integer> emailToAccountIdx = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailToAccountIdx.containsKey(email)) {
                    // Union current account with the account that already owns this email
                    int root1 = find(parent, i);
                    int root2 = find(parent, emailToAccountIdx.get(email));
                    if (root1 != root2) {
                        parent[root1] = root2;
                    }
                } else {
                    emailToAccountIdx.put(email, i);
                }
            }
        }

        // Group emails by their ultimate root account index
        Map<Integer, List<String>> rootToEmails = new HashMap<>();
        for (String email : emailToAccountIdx.keySet()) {
            int rootIdx = find(parent, emailToAccountIdx.get(email));
            rootToEmails.putIfAbsent(rootIdx, new ArrayList<>());
            rootToEmails.get(rootIdx).add(email);
        }

        // Format the output
        List<List<String>> result = new ArrayList<>();
        for (int rootIdx : rootToEmails.keySet()) {
            List<String> emails = rootToEmails.get(rootIdx);
            Collections.sort(emails); // Sort emails alphabetically
            
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(accounts.get(rootIdx).get(0)); // Add the display name
            mergedAccount.addAll(emails);
            result.add(mergedAccount);
        }

        return result;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent, parent[i]); // Path compression
    }
}