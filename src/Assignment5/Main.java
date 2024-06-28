package Assignment5;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static Map<String, PartyDO> partyMap = new HashMap<String, PartyDO>();
    public static Map<String,LinkedHashMap<String, basePolicyDO>> policyMap = new LinkedHashMap<String,LinkedHashMap<String, basePolicyDO>>();
    public static List<String> countries = Arrays.asList("India", "Australia");
    public static Map<String, List<String>> statesMap = new HashMap<String, List<String>>();
    public static Map<String, AgentDO> agentMap = new LinkedHashMap<String, AgentDO>();

    public static Scanner scanner = new Scanner(System.in);

    static {
        statesMap.put("India", Arrays.asList("Maharashtra", "West Bengal"));
        statesMap.put("Australia", Arrays.asList("Melbourne", "Sydney"));
    }

    public static void main(String[] args) throws Exception {
    	agentMap.put("AGENT001", new AgentDO("AGENT001", "Kaustubh Ayare", "+1234567890", "kaustubh.ayare@c2lbiz.com"));
        agentMap.put("AGENT002", new AgentDO("AGENT002", "Prathmesh Pawar", "+1987654321", "prathmesh.pawar@c2lbiz.com"));
        agentMap.put("AGENT003", new AgentDO("AGENT003", "Deepak Kumavat", "+1122334455", "deepak.kumavat@c2lbiz.com"));
        agentMap.put("AGENT004", new AgentDO("AGENT004", "Kunj Shah", "+1445566778", "kunj.shah@c2lbiz.com"));
        agentMap.put("AGENT005", new AgentDO("AGENT005", "Asmi Purohit", "+1654321876", "asmi.purohit@c2lbiz.com"));
        while (true) {
            System.out.println("1. Create Party");
            System.out.println("2. Edit Party");
            System.out.println("3. Delete Party");
            System.out.println("4. Search Party");
            System.out.println("5. Download Party Details");
            System.out.println("6. Buy Term Insurance");
            System.out.println("7. Buy Term Insurance");
            System.out.println("8. Search Policy");
            System.out.println("9. Upgrade Premium");
            System.out.println("10. Agent Report");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    createParty();
                    break;
                case 2:
                    editParty();
                    break;
                case 3:
                    deleteParty();
                    break;
                case 4:
                    try 
                    {
                        searchParty();
                    } 
                    catch (NoSuchRecordFoundException e) 
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    downloadPartyDetails();
                    break;
                case 6:
                	buyTermInsurancePolicy();
                	break;
                case 7:
                	buyTermHealthInsurancePolicy();
                	break;
                case 8:
                	searchPolicy();
                	break;
                case 9:
                	updatePremium();
                	break;
                case 10:
                	generateAgentReport();
                	break;
                case 11:
                	System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void createParty() {
        PartyDO party = new PartyDO();
        
        
        int partySeq = SequenceGenerator.getInstance().currentPartySequence;
        party.setPartySeq(String.valueOf(partySeq));
        SequenceGenerator.getInstance().currentPartySequence++;

        System.out.print("Enter Party Type (INDIVIDUAL/ORGANIZATION): ");
        String partyTypeCd = scanner.nextLine().toUpperCase();
        if (!partyTypeCd.equals("INDIVIDUAL") && !partyTypeCd.equals("ORGANIZATION")) {
            System.out.println("Invalid Party Type.");
            return;
        }
        party.setPartyTypeCd(partyTypeCd);

        System.out.print("Enter Title (MR/MS/MRS): ");
        String title = scanner.nextLine().toUpperCase();
        if (!title.equals("MR") && !title.equals("MS") && !title.equals("MRS")) {
            System.out.println("Invalid Title.");
            return;
        }
        party.setTitle(title);

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        if (firstName.isEmpty() || !firstName.matches("[a-zA-Z]+")) {
            System.out.println("Invalid First Name.");
            return;
        }
        party.setFirstName(firstName);

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        party.setLastName(lastName);

        System.out.print("Enter Birth Date (yyyy-mm-dd): ");
        String birthDateStr = scanner.nextLine();
        try {
            Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDateStr);
            if (birthDate.after(new Date())) {
                System.out.println("Birth Date cannot be in the future.");
                return;
            }
            party.setBirthDate(birthDate);
            party.setAge(calculateAge(birthDate));
        } catch (Exception e) {
            System.out.println("Invalid Birth Date format.");
            return;
        }

        System.out.print("Enter Gender (MALE/FEMALE/TRANSGENDER): ");
        String genderCd = scanner.nextLine().toUpperCase();
        if (!genderCd.equals("MALE") && !genderCd.equals("FEMALE") && !genderCd.equals("TRANSGENDER")) {
            System.out.println("Invalid Gender.");
            return;
        }
        party.setGenderCd(genderCd);

        addAddresses(party);
        addContacts(party);

        partyMap.put(String.valueOf(partySeq), party);
        
        System.out.println("Party created successfully with Party Sequence: " + partySeq);
    }

    public static void addAddresses(PartyDO party) {
        boolean addMore = true;
        while (addMore) {
            System.out.print("Enter address type (RESIDENTIAL/OFFICE): ");
            String addressType = scanner.nextLine().toUpperCase();

            System.out.println("Select Country:");
            for (int i = 0; i < countries.size(); i++) {
                System.out.println((i + 1) + ". " + countries.get(i));
            }
            int countryIndex = scanner.nextInt() - 1;
            scanner.nextLine();
            if (countryIndex < 0 || countryIndex >= countries.size()) {
                System.out.println("Invalid Country selection.");
                return;
            }
            String countryCd = countries.get(countryIndex);

            System.out.println("Select State:");
            List<String> states = statesMap.get(countryCd);
            for (int i = 0; i < states.size(); i++) {
                System.out.println((i + 1) + ". " + states.get(i));
            }
            int stateIndex = scanner.nextInt() - 1;
            scanner.nextLine();
            if (stateIndex < 0 || stateIndex >= states.size()) {
                System.out.println("Invalid State selection.");
                return;
            }
            String stateCd = states.get(stateIndex);

            System.out.print("Enter address details: ");
            String addressDetails = scanner.nextLine();

            System.out.print("Enter pin code: ");
            String pinCode = scanner.nextLine();

            System.out.print("Is this the primary address? (YES/NO): ");
            String primaryAddress = scanner.nextLine().toUpperCase();

            PartyAddressDO address = new PartyAddressDO(String.valueOf(SequenceGenerator.getInstance().currentAddressSequence), addressType, countryCd, stateCd, addressDetails, pinCode, primaryAddress);
            party.addPartyAddress(address);
            SequenceGenerator.getInstance().currentAddressSequence++;

            System.out.print("Do you want to add another address? (YES/NO): ");
            addMore = scanner.nextLine().equalsIgnoreCase("YES");
        }

        ensurePrimaryAddress(party);
    }

    public static void ensurePrimaryAddress(PartyDO party) {
        boolean hasPrimaryAddress = false;
        for (PartyAddressDO address : party.getPartyAddressDOs()) {
            if (address.getPrimaryAddress().equalsIgnoreCase("YES")) {
                hasPrimaryAddress = true;
                break;
            }
        }

        if (!hasPrimaryAddress) {
            System.out.println("You must have at least one primary address.");
            System.out.println("Please select one of the addresses to be the primary address:");
            List<PartyAddressDO> addresses = party.getPartyAddressDOs();
            for (int i = 0; i < addresses.size(); i++) {
                System.out.println((i + 1) + ". " + addresses.get(i).getAddressDetails());
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            addresses.get(choice - 1).setPrimaryAddress("YES");
        }
    }

    public static void addContacts(PartyDO party) {
        boolean addMore = true;
        while (addMore) {
            System.out.print("Enter contact type (MOBILE/RESIDENTIAL/OFFICE): ");
            String contactType = scanner.nextLine().toUpperCase();

            System.out.print("Enter contact number: ");
            String contactNum = scanner.nextLine();

            PartyContactDO contact = new PartyContactDO(String.valueOf(SequenceGenerator.getInstance().currentContactSequence), contactType, contactNum);
            party.addPartyContact(contact);
            SequenceGenerator.getInstance().currentContactSequence++;

            System.out.print("Do you want to add another contact? (YES/NO): ");
            addMore = scanner.nextLine().equalsIgnoreCase("YES");
        }
    }
    public static void editParty() {
        System.out.print("Enter Party Sequence to edit: ");
        String partySeq = scanner.nextLine();
        PartyDO party = partyMap.get(partySeq);
        if (party == null) {
            System.out.println("Party not found.");
            return;
        }

        System.out.println("Edit Party Details:");
        System.out.println("1. Edit Party Info");
        System.out.println("2. Edit Party Addresses");
        System.out.println("3. Edit Party Contacts");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                editPartyInfo(party);
                break;
            case 2:
                editPartyAddress(party);
                break;
            case 3:
                editPartyContact(party);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    public static void editPartyInfo(PartyDO party) {
        System.out.print("Enter new Party Type (INDIVIDUAL/ORGANIZATION): ");
        String partyTypeCd = scanner.nextLine().toUpperCase();
        if (!partyTypeCd.equals("INDIVIDUAL") && !partyTypeCd.equals("ORGANIZATION")) {
            System.out.println("Invalid Party Type.");
            return;
        }
        party.setPartyTypeCd(partyTypeCd);

        System.out.print("Enter new Title (MR/MS/MRS): ");
        String title = scanner.nextLine().toUpperCase();
        if (!title.equals("MR") && !title.equals("MS") && !title.equals("MRS")) {
            System.out.println("Invalid Title.");
            return;
        }
        party.setTitle(title);

        System.out.print("Enter new First Name: ");
        String firstName = scanner.nextLine();
        if (firstName.isEmpty() || !firstName.matches("[a-zA-Z]+")) {
            System.out.println("Invalid First Name.");
            return;
        }
        party.setFirstName(firstName);

        System.out.print("Enter new Last Name: ");
        party.setLastName(scanner.nextLine());

        System.out.print("Enter new Birth Date (yyyy-mm-dd): ");
        String birthDateStr = scanner.nextLine();
        try {
            Date birthDate = new SimpleDateFormat("yyyy-mm-dd").parse(birthDateStr);
            if (birthDate.after(new Date())) {
                System.out.println("Birth Date cannot be in the future.");
                return;
            }
            party.setBirthDate(birthDate);
            party.setAge(calculateAge(birthDate));
        } catch (Exception e) {
            System.out.println("Invalid Birth Date format.");
            return;
        }

        System.out.print("Enter new Gender (MALE/FEMALE/TRANSGENDER): ");
        String genderCd = scanner.nextLine().toUpperCase();
        if (!genderCd.equals("MALE") && !genderCd.equals("FEMALE") && !genderCd.equals("TRANSGENDER")) {
            System.out.println("Invalid Gender.");
            return;
        }
        party.setGenderCd(genderCd);

        System.out.println("Party details updated successfully.");
    }

    public static void editPartyAddress(PartyDO party) {
        List<PartyAddressDO> addressList = party.getPartyAddressDOs();
        for (int i = 0; i < addressList.size(); i++) {
            System.out.println((i + 1) + ". " + addressList.get(i).getAddressDetails());
        }
        System.out.print("Choose an address to edit: ");
        int addressIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        if (addressIndex < 0 || addressIndex >= addressList.size()) {
            System.out.println("Invalid selection.");
            return;
        }
        PartyAddressDO address = addressList.get(addressIndex);

        System.out.print("Enter new Address Type (RESIDENTIAL/OFFICE): ");
        String addressType = scanner.nextLine().toUpperCase();
        if (!addressType.equals("RESIDENTIAL") && !addressType.equals("OFFICE")) {
            System.out.println("Invalid Address Type.");
            return;
        }
        address.setAddressType(addressType);

        System.out.println("Select new Country:");
        for (int i = 0; i < countries.size(); i++) {
            System.out.println((i + 1) + ". " + countries.get(i));
        }
        int countryIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        if (countryIndex < 0 || countryIndex >= countries.size()) {
            System.out.println("Invalid Country selection.");
            return;
        }
        String countryCd = countries.get(countryIndex);
        address.setCountryCd(countryCd);

        System.out.println("Select new State:");
        List<String> states = statesMap.get(countryCd);
        for (int i = 0; i < states.size(); i++) {
            System.out.println((i + 1) + ". " + states.get(i));
        }
        int stateIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        if (stateIndex < 0 || stateIndex >= states.size()) {
            System.out.println("Invalid State selection.");
            return;
        }
        String stateCd = states.get(stateIndex);
        address.setStateCd(stateCd);

        System.out.print("Enter new Address Details: ");
        address.setAddressDetails(scanner.nextLine());

        System.out.print("Enter new Pin Code: ");
        address.setPinCode(scanner.nextLine());

        System.out.print("Is this the primary address? (YES/NO): ");
        address.setPrimaryAddress(scanner.nextLine().toUpperCase());
        
        ensurePrimaryAddress(party);

        System.out.println("Address updated successfully.");
    }

    public static void editPartyContact(PartyDO party) {
        List<PartyContactDO> contactList = party.getPartyContactDOs();
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println((i + 1) + ". " + contactList.get(i).getContactDetails());
        }
        System.out.print("Choose a contact to edit: ");
        int contactIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        if (contactIndex < 0 || contactIndex >= contactList.size()) {
            System.out.println("Invalid selection.");
            return;
        }
        PartyContactDO contact = contactList.get(contactIndex);

        System.out.print("Enter new Contact Type (MOBILE/RESIDENTIAL/OFFICE): ");
        String contactType = scanner.nextLine().toUpperCase();
        if (!contactType.equals("MOBILE") && !contactType.equals("RESIDENTIAL") && !contactType.equals("OFFICE")) {
            System.out.println("Invalid Contact Type.");
            return;
        }
        contact.setContactType(contactType);

        System.out.print("Enter new Contact Number: ");
        contact.setContactNum(scanner.nextLine());

        System.out.println("Contact updated successfully.");
    }

    public static void deleteParty() {
        System.out.print("Enter Party Sequence to delete: ");
        String partySeq = scanner.nextLine();
        if (partyMap.remove(partySeq) != null) {
            System.out.println("Party deleted successfully.");
        } else {
            System.out.println("Party not found.");
        }
    }

    public static void searchParty() throws NoSuchRecordFoundException 
    {
        System.out.print("Enter Party Sequence to search: ");
        String partySeq = scanner.nextLine();
        PartyDO party = partyMap.get(partySeq);
        if (party == null) 
        {
            throw new NoSuchRecordFoundException("Party not found.");
        }

        System.out.println("Party Details:");
        System.out.println("Party Sequence: " + party.getPartySeq());
        System.out.println("Party Type: " + party.getPartyTypeCd());
        System.out.println("Title: " + party.getTitle());
        System.out.println("First Name: " + party.getFirstName());
        System.out.println("Last Name: " + party.getLastName());
        System.out.println("Birth Date: " + new SimpleDateFormat("yyyy-mm-dd").format(party.getBirthDate()));
        System.out.println("Age: " + party.getAge());
        System.out.println("Gender: " + party.getGenderCd());
        System.out.println("Addresses:");
        for (PartyAddressDO address : party.getPartyAddressDOs()) {
            System.out.println("  Address Sequence: " + address.getAddressSeq());
            System.out.println("  Address Type: " + address.getAddressType());
            System.out.println("  Country: " + address.getCountryCd());
            System.out.println("  State: " + address.getStateCd());
            System.out.println("  Address Details: " + address.getAddressDetails());
            System.out.println("  Pin Code: " + address.getPinCode());
            System.out.println("  Primary Address: " + address.getPrimaryAddress());
        }
        System.out.println("Contacts:");
        for (PartyContactDO contact : party.getPartyContactDOs()) {
            System.out.println("  Contact Sequence: " + contact.getContactSeq());
            System.out.println("  Contact Type: " + contact.getContactType());
            System.out.println("  Contact Number: " + contact.getContactNum());
        }
    }

    public static void downloadPartyDetails() throws Exception {
        System.out.print("Enter Party Sequence to download details: ");
        String partySeq = scanner.nextLine();
        PartyDO party = partyMap.get(partySeq);
        if (party == null) {
            System.out.println("Party not found.");
            return;
        }
        
        String dirPath = "C:\\Users\\kaustubh.ayare\\Downloads\\jar\\war\\"; 
        String fileName = "party_" + partySeq + ".txt";
        String fileData = "Party Sequence: " + party.getPartySeq()+"\n"+"Party Type: " + party.getPartyTypeCd()+"\n"+"Title: " + party.getTitle()+"\n"+"First Name: " + party.getFirstName()+"\n"+"Last Name: " + party.getLastName()+"\n"+"Birth Date: " + new SimpleDateFormat("yyyy-mm-dd").format(party.getBirthDate())+"\n"+"Age: " + party.getAge()+"\n"+"Gender: " + party.getGenderCd()+"\n"+"Addresses:"+party.getPartyAddressDOs()+"\n"+"Contacts:"+"\n"+party.getPartyContactDOs();

        FileUtil.createFile(dirPath, fileName, fileData);
        System.out.println("Party details downloaded successfully.");            
    }
    public static void buyTermInsurancePolicy() {
        System.out.print("Enter Party Sequence: ");
        String partySeq = scanner.nextLine();

        
        PartyDO party = partyMap.get(partySeq);
        if (party == null) {
            System.out.println("Party not found.");
            return;
        }

        
        LinkedHashMap<String, basePolicyDO> policies = policyMap.get(partySeq);
        if (policies == null) {
            policies = new LinkedHashMap<String, basePolicyDO>();
        }

       
        if (policies.containsKey("TERMINSURANCE")) {
            System.out.println("Party already has a Term Insurance Policy.");
            return;
        }

        
        int policySeq = SequenceGenerator.getInstance().CurrentPolicySequence;

        
        System.out.print("Enter Sum Assured: ");
        double sumAssured = scanner.nextDouble();
        scanner.nextLine(); 

       
        System.out.println("Available Agent IDs: ");
        for (String agentId : agentMap.keySet()) {
            System.out.println(agentId);
        }
        System.out.print("Select Agent ID from the above list: ");
        String agentId = scanner.nextLine();
        if (!agentMap.containsKey(agentId)) {
            System.out.println("Invalid Agent ID.");
            return;
        }

        
        double premiumAmt = premiumCalculationDO.premiumCalTermIns(sumAssured);

        
        termInsuranceDO termInsurancePolicy = new termInsuranceDO(partySeq, String.valueOf(policySeq), premiumAmt, sumAssured, agentId);
        policies.put("TERMINSURANCE", termInsurancePolicy);
        policyMap.put(partySeq, policies);

       
        SequenceGenerator.getInstance().CurrentPolicySequence++;
        System.out.println("Term Insurance Policy added successfully. Term Insurance Policy Sequence is " + policySeq);
    }

    public static void buyTermHealthInsurancePolicy() {
        System.out.print("Enter Party Sequence: ");
        String partySeq = scanner.nextLine();

        
        PartyDO party = partyMap.get(partySeq);
        if (party == null) {
            System.out.println("Party not found.");
            return;
        }

        
        LinkedHashMap<String, basePolicyDO> policies = policyMap.get(partySeq);
        if (policies == null) {
            policies = new LinkedHashMap<String, basePolicyDO>();
        }

       
        if (policies.containsKey("TERMHEALTHINSURANCE")) {
            System.out.println("Party already has a Term Health Insurance Policy.");
            return;
        }

        
        int policySeq = SequenceGenerator.getInstance().CurrentPolicySequence;

        
        System.out.print("Enter Sum Assured: ");
        double sumAssured = scanner.nextDouble();
        scanner.nextLine(); 

        
        System.out.println("Available Agent IDs: ");
        for (String agentId : agentMap.keySet()) {
            System.out.println(agentId);
        }
        System.out.print("Select Agent ID from the above list: ");
        String agentId = scanner.nextLine();
        if (!agentMap.containsKey(agentId)) {
            System.out.println("Invalid Agent ID.");
            return;
        }

        
        double healthCover = sumAssured * 0.05;
        double premiumAmt = premiumCalculationDO.premiumCalTermIns(sumAssured);

        
        termHealthInsuranceDO termHealthInsurancePolicy = new termHealthInsuranceDO(partySeq, String.valueOf(policySeq), premiumAmt, sumAssured, healthCover, agentId);
        policies.put("TERMHEALTHINSURANCE", termHealthInsurancePolicy);
        policyMap.put(partySeq, policies);

        
        SequenceGenerator.getInstance().CurrentPolicySequence++;
        System.out.println("Term Health Insurance Policy added successfully. Term Health Insurance Policy Sequence is " + policySeq);
    }

    public static void searchPolicy() {
        System.out.println("Choose search criteria:");
        System.out.println("1. By Policy Type");
        System.out.println("2. By Policy Holder Name");
        System.out.println("3. By Sum Assured");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                System.out.print("Enter Policy Type (termInsurance/termHealthInsurance): ");
                String policyType = scanner.nextLine();
                searchByPolicyType(policyType);
                break;
            case 2:
                System.out.print("Enter Policy Holder First Name: ");
                String firstName = scanner.nextLine();
                System.out.print("Enter Policy Holder Last Name: ");
                String lastName = scanner.nextLine();
                searchByPolicyHolderName(firstName, lastName);
                break;
            case 3:
                System.out.print("Enter Sum Assured (use '>' or '<' followed by amount): ");
                String sumAssuredCondition = scanner.nextLine();
                searchBySumAssured(sumAssuredCondition);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void searchByPolicyType(String policyType) {
        for (Map.Entry<String, LinkedHashMap<String, basePolicyDO>> partyEntry : policyMap.entrySet()) {
            LinkedHashMap<String, basePolicyDO> policies = partyEntry.getValue();
            for (basePolicyDO policy : policies.values()) {
                if (policyType.equalsIgnoreCase("termInsurance") && policy instanceof termInsuranceDO) {
                    System.out.println(policy);
                } else if (policyType.equalsIgnoreCase("termHealthInsurance") && policy instanceof termHealthInsuranceDO) {
                    System.out.println(policy);
                }
            }
        }
    }

    public static void searchByPolicyHolderName(String firstName, String lastName) {
        for (Map.Entry<String, PartyDO> partyEntry : partyMap.entrySet()) {
            PartyDO party = partyEntry.getValue();
            if (party.getFirstName().equalsIgnoreCase(firstName) && party.getLastName().equalsIgnoreCase(lastName)) {
                LinkedHashMap<String, basePolicyDO> policies = policyMap.get(party.getPartySeq());
                if (policies != null) {
                    for (basePolicyDO policy : policies.values()) {
                        System.out.println(policy);
                    }
                }
            }
        }
    }

    public static void searchBySumAssured(String sumAssuredCondition) {
        sumAssuredCondition = sumAssuredCondition.trim();
        
        char operator = sumAssuredCondition.charAt(sumAssuredCondition.length() - 1);
        String amountString = sumAssuredCondition.substring(0, sumAssuredCondition.length() - 1).trim();
        
        double amount;
        try {
            amount = Double.parseDouble(amountString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount format.");
            return;
        }
        
        for (Map.Entry<String, LinkedHashMap<String, basePolicyDO>> partyEntry : policyMap.entrySet()) {
            LinkedHashMap<String, basePolicyDO> policies = partyEntry.getValue();
            for (basePolicyDO policy : policies.values()) {
                double sumAssured;
                if (policy instanceof termInsuranceDO) {
                    sumAssured = ((termInsuranceDO) policy).getSumAssured();
                } else if (policy instanceof termHealthInsuranceDO) {
                    sumAssured = ((termHealthInsuranceDO) policy).getSumAssured();
                } else {
                    continue;
                }
                
                if ((operator == '>' && sumAssured > amount) || (operator == '<' && sumAssured < amount)) {
                    System.out.println(policy);
                }
            }
        }
    }

    public static void updatePremium() 
    {
        for (Map.Entry<String, LinkedHashMap<String, basePolicyDO>> entry : policyMap.entrySet()) 
        {
            LinkedHashMap<String, basePolicyDO> policies = entry.getValue();
 
            for (Map.Entry<String, basePolicyDO> policyEntry : policies.entrySet()) 
            {
                basePolicyDO policy = policyEntry.getValue();
 
                if (policy instanceof termInsuranceDO)
                {
                    termInsuranceDO termPolicy = (termInsuranceDO) policy;
                    double newPremium = termPolicy.getPremiumAmt() * 1.05; 
                    termPolicy.setPremiumAmt(newPremium);
                } 
                else if (policy instanceof termHealthInsuranceDO) {
                    termHealthInsuranceDO healthPolicy = (termHealthInsuranceDO) policy;
                    double newPremium = healthPolicy.getPremiumAmt() * 1.07; 
                    healthPolicy.setPremiumAmt(newPremium);
                }
            }
        }
    }
    public static void generateAgentReport() {
        Map<String, AgentReportDO> agentReportMap = new LinkedHashMap<String, AgentReportDO>();

        
        for (Map.Entry<String, LinkedHashMap<String, basePolicyDO>> entry : policyMap.entrySet()) {
            for (basePolicyDO policy : entry.getValue().values()) {
                String agentId = null;
                double sumAssured = 0.0;

                if (policy instanceof termInsuranceDO) {
                    termInsuranceDO termPolicy = (termInsuranceDO) policy;
                    agentId = termPolicy.getAgentId();
                    sumAssured = termPolicy.getSumAssured();
                } else if (policy instanceof termHealthInsuranceDO) {
                    termHealthInsuranceDO healthPolicy = (termHealthInsuranceDO) policy;
                    agentId = healthPolicy.getAgentId();
                    sumAssured = healthPolicy.getSumAssured();
                }

                if (agentId != null) {
                    AgentReportDO report = agentReportMap.get(agentId);
                    if (report == null) {
                        report = new AgentReportDO(agentId, 0, 0.0);
                        agentReportMap.put(agentId, report);
                    }

                    report.incrementPolicyCount();
                    report.addToTotalSumAssured(sumAssured);
                }
            }
        }

        
        System.out.println("Available Agent IDs:");
        for (String agentId : agentMap.keySet()) {
            System.out.println(agentId);
        }

        
        System.out.print("Enter Agent ID: ");
        String agentId = scanner.nextLine();

        
        AgentReportDO report = agentReportMap.get(agentId);
        if (report != null) {
            System.out.println("Agent Report:");
            System.out.println("Agent ID: " + report.getAgentId());
            System.out.println("Number of Policies Sold: " + report.getPolicyCount());
            System.out.println("Total Sum Assured: " + report.getTotalSumAssured());
        } else {
            System.out.println("No policies found for the given Agent ID.");
        }
    }
    public static int calculateAge(Date birthDate) 
    {
        Calendar birthCal = Calendar.getInstance();
        birthCal.setTime(birthDate);
        Calendar todayCal = Calendar.getInstance();
        int age = todayCal.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR);
        if (todayCal.get(Calendar.DAY_OF_YEAR) < birthCal.get(Calendar.DAY_OF_YEAR)) 
        {
            age--;
        }
        return age;
    }
}
