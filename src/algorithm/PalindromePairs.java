package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]

Example 2:
Given words = ["abcd", "dcba", "lls", "s", "sssll"]
Return [[0, 1], [1, 0], [3, 2], [2, 4]]
The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
*/
public class PalindromePairs {
    
	public static boolean isPalindrome(String str)
	{
		for (int i = 0; i < str.length() / 2; i ++)
		{
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
		}
		return true;
	}
/*	
	public static boolean isPalindrome(String a, String b)
	{
		
		if (a.length() == b.length())
		{
			for (int i = 0; i < a.length(); i ++)
			{
				if (a.charAt(i) != b.charAt(i)) return false;
			}
			return true;
		}
		else 
		{
			int minlen = Math.min(a.length(), b.length());
			boolean subtrue = true;
			if (a.length() > minlen)
			{
				for (int i = minlen; i < a.length() - minlen/ 2; i ++)
				{
					if (a.charAt(i) != a.charAt(a.length() - 1 - i)) 
						{
						subtrue = false;
						break;
						}
				}
				subtrue = true;
			}
			else
			{
				for (int i = minlen; i < b.length() - minlen/ 2; i ++)
				{
					if (b.charAt(i) != b.charAt(b.length() - 1 - i)) 
						{
						subtrue = false;
						break;
						}
				}
				subtrue = true;
			}
			
			if (!subtrue) return false;
			
			for (int i = 0; i < minlen; i ++)
			{
				if (a.charAt(i) != b.charAt(i)) return false;
			}
			return true;
			
		}
		
	}
*/	
	
	public static boolean isPalindrome(String a, String b)
	{
		
		if (a.length() == b.length())
		{
			for (int i = 0; i < a.length(); i ++)
			{
				if (a.charAt(i) != b.charAt(a.length() - 1 - i)) return false;
			}
			return true;
		}
		else 
		{
			int minlen = Math.min(a.length(), b.length());
			boolean subtrue = true;
			if (a.length() > minlen)
				subtrue = isPalindrome(a.substring(minlen));
			else
				subtrue = isPalindrome(b.substring(0, b.length() - minlen - 1));
			if (!subtrue) return false;
			
			for (int i = 0; i < minlen; i ++)
			{
				if (a.charAt(i) != b.charAt(b.length() - 1 - i)) return false;
			}
			return true;
			/*
			if (a.length() > minlen)
				return isPalindrome(a.substring(minlen));
			else
				return isPalindrome(b.substring(0, b.length() - minlen - 1));
				*/
		}
		
	}
	
	public static List<List<Integer>> palindromePairs(String[] words) {
    
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		for (int i = 0; i < words.length - 1; i ++)
        {
        	for (int j = i + 1; j < words.length; j ++)
        	{
        		if (isPalindrome(words[i], words[j]))
        			results.add(Arrays.asList(i, j));
        		if (isPalindrome(words[j], words[i]))
        			results.add(Arrays.asList(j, i));
        	}
        }
		return results;
    }
	
	public static void main(String[] args)
	{
		//String[] words = {"a", ""};
		
		//String[] words = {"bfdijce","gce","bhgchdcejfcgjfiece","dcebhjhjfgcjdfjg","ejgbjebi","fffgigehhabhfhdge","fajahcagah","ja","ghedcicbg","ccifjedjig","gihbhhebhheecgeifcii","gdjfajdhgibgdb","hcjjdi","jhfjecjigjdhbga","dejbejddhje","ecgfijhcja","ghejidhebg","hfehjfhhfjdjeeahjad","bbajfihihbacdefh","cdeeebaab","cdagiaffffjbjcaia","ab","ejaieca","hcfiecbfcjjhhdj","aehjicd","ieciciiehidbfaaifcj","dca","cjachjbgbefffci","i","j","ejbggahbhii","gjdcjfbhefdgd","ecaed","jbbbjffjgib","biiejcgbcahijgbibiaa","aeahieeceggchd","djicdd","cbj","ggfbeifejd","jgjhehhe","fdgib","ddgabdicbibj","ejbcdfiacicegiibeje","bfdcd","hhjajfgefgefa","cecgbebfchia","jchdbcbh","jcegc","dejfjjcbcdiadaaaei","bjbhfa","ibjba","iddhgdjgjgeid","ifiigfijhad","ahihjcfh","degiedaj","fjfhhiddacjdij","ecjhgc","beebfahffgjaabjafi","fcbdijfjgifjgbijdfc","fc","jgbjajjae","edcgjcigdeecbdhif","fhbhjcbajfddifci","ch","jahggfgdjidhihcafcji","effbcdfbfjdegacdhgc","acjajjbeaeedjbcfihd","bag","ffjdidbghbfdeh","eice","h","aeffjeagfigicadg","hgbejbgcecejfeg","hh","bbadbcbiaechiid","dicajhebdhcgfhgbafa","ehig","eaeddiebehiabf","beijag","gaabbe","gfiehgehe","hffcdfdhcfiia","efbfhe","fdg","hddeaaeacadbhf","dd","hcaicbbjaechebfj","aibjjfdhgchjjhhabe","bjgicf","aij","icaajcfdad","f","fgieaifhghgchhcbjad","gbfjgaabffdeafgejef","bebhbdgjbchbheegba","ceefea","eadjbjfacjeaihefbc","eghihceecbgiehihe","icadjeefhiead","jjibgdb","efedigddjfdea","c","d","hhcjhbdggcbdif","ejhga","fejfbccaeac","ehjbeje","dehd","caddigbdaabdffaie","bjjgjiehaffaachfh","ehhaicejafgddcfihee","jefii","gbijjebhdehi","bfdbcajjfdfh","ca","jbbfibdadiefah","bbefdfcghcaaiijb","ib","ce","bbfdb","cbbcbjebjbjhcfd","ecjge","gjdegighaagbhjc","afdcgdggbi","hdgah","gahdgc","jfbgeaebbd","cefbhfcabagjhjhgeabd","jdaacjjdbc","efacbghiheihedfi","fbffgdcajadjh","aib","ihdcfibgegedeaaa","gehbcj","hjfajbbdc","ihafhfddfhbfgc","fhecfcjd","adefabbggidhgcjf","dedfejiddhcgabfcbihc","hbibhhghhajg","iabjgjihiiiebeig","iegajfg","aaj","gfdhaahdbcbfgja","jd","ifeibdfegjcafdiee","dhjih","afbfdf","gjighgaebb","cbdfjddjfb","aa","gbcajjeajjcfg","gcd","gefddc","fcbiehbiaddcbgfccbid","ifjbgdc","hhgdebcf","iabe","bihj","ifajbhjjhbcd","diabbjjh","bgjhihhgba","jfjcfgbchdfhhggcg","ahdbehfhhccfeefcicf","dghf","dacagebbcieggjjbfi","hejjgdhjbeggedbbgj","a","gghibdbhf","cadfh","fhfbgdegfhccf","hcihffaibjedbjcef","ghhibbgdhgibbfj","jaegfhahhe","fjacga","cjfacjichhhcbhfhbj","gdaejffeiiigfiaci","cdfejfjf","ddf","fhfeifgi","ghghiedhejdhicfhgiaj","abajg","daajgijcdh","bfaiabeaahifjjfdf","ccfhjiegdaj","bhbeegihbifefiia","fb","cjffbhfbgjjfadih","dhefhfaajejee","deijihhhjjibfea","jbgij","agfdidigfeada","daecfjiaacigcjjcb","bgdiied","cjadgiie","ghbhfci","jdbfhhhach","ifiegeaad","eajhiechdhjfhdecfjhe","jhbd","gje","edeggghabeefcaa","aeebiaheefjbigge","bfdhjacgjdficad","fiafgifgajciafiib","aiejhc","gh","eidfbdfcffci","hbdbbcaghejgchiegjf","cdffefdhbfgh","hbjiahfgiiejfcfbg","fdfccabdbggbifhjhjga","dhggbecfhdhcbfddafe","ihee","ciaadifia","gd","hac","dhgaegbichdafdiehe","agdfefdjdbcg","fe","hgdhef","cfgccibbfbcjicg","jj","gdh","decghhbfdcaaiafecaf","jibccbadhdfabjehfi","gaibdjdgjdifcadce","hdcbeegf","ebdaj","fgcdh","hgfabihbhibcdccgd","dhehjgicjhhibfghacig","dgfiagb","jhadfjfafagaggfg","eegg","bjaaeig","chfi","fbb","djcieficibgiiabjdbdc","gdcjijfajgbcb","digh","gbhjcfafhjgchgabjfe","jhggiggjd","eeccgibhheheaaajfadd","bcdcggagb","gbbdbjgi","jchahjcaahbad","bjefigc","ggfhee","ejb","ficidccfgffehdi","iadghjbahjeeja","ighibfegabfegfjafab","dfaeejga","bffbbja","hebbgeigchdb","cfdi","dhha","fjfhfjcabe","gfcca","adeffi","fidgieaijfjcjhgfc","igibid","jjhechdbabegjabdjfc","ai","dgc","aehhchefa","beihbjaahe","ebiagd","bfcafajjahbid","baiijjfgjibafacg","hhajgicga","deadad","efcahgh","aiciffj","hhjchdfeiabfjiiie","agihihabbc","ccacdghah","eifhbbidjbceaegc","hfadbaediajcfbb","jjjjcgeaacffgg","dceiidhcigcbgc","biabjchfi","chgjbhigebba","ciggdgfigbjjjdeccgba","cehe","caidbdi","fjeecdebhidchfeggja","hfbbccad","bbbaggbegaihc","cdahjdjeifccjijdiabj","jcjj","jagf","afagefhgiahebich","fjgejbbdbgab","aih","bgjabhffeafj","fgcghbcheg","ebacdfbchhiaffjgeh","ehhejdbdgg","hafgeiahaffgicafjffi","bbhajadcdeihbggfi","fbdbg","edbiaihc","ed","gcdeefbhidc","gijcigefcecgffjfie","hjg","jahfaghjjbafaebcccf","ahjhafidhbic","gecihhgbhgeeaga","feagfagcef","fhahccbfddhfcaidaa","hajchgjeb","ajhbhfjdfgfdebbgaa","jiedjcgbgifafi","hiaje","cafbaibebabjdadcc","icicefadeecaiceiiaf","jeejjedbfh","ajjdi","diafeaahaeb","heedafafabhcg","hfgdbchbigddjaffg","adahedgichjhhhghg","eajjafcdadbbhfeii","cfachcdbhbcd","fabiigh","gegdbcfghcc","igafadcghfcgbhfccdf","cdbbgbgfggjjedci","ehghd","hgadfefdeeh","ccbeibahfc","jfeag","dihhjehhab","geigahebghifjihdgcfd","fefhbciachhjafj","egdcjbdhgja","fbdfae","cgbdeffbacchjfeig","jgic","caefggbjjdbbjcjfbagb","ddaadegchiejjjbf","ad","dabhgddjgahaach","eddaad","hjbfa","hccejcgcbebfffdhibe","gjababagaaa","ghbjfadjjejaga","cgcdcfadhgdeff","bfihdibecfjehaef","jhijchdaeahdjdfgeac","jb","ejfihbbebihhed","jecgdefeheiebfeabb","aibchhafgcbefdah","dcgefai","fcafbgbfh","gjdaef","eciidjhcbgachbdfjha","dddbccahjdafacjeaib","eifcchejafiijagca","gg","jihahehccafjfdg","dhfia","geghggbdfdgficdhccij","bajjefgdcedjdededd","gdghcgb","bf","gjaeidd","bagc","b","ahaeecafgaafgiif","hfgjbgjicigbciggh","jcfhdgaddbhhgfiebgfi","fejbgcddja","gebjehgdbfhcfidcidhh","ggcaafdbbaiefd","hfaggjab","begicebfhiceicajcfj","iefhaahfajdfchfhecee","icj","cegijjjjfehded","eeadcidaecejchabicbe","ajhhdcachhi","gifibbgaabghj","cajdcfeaefaegdag","bdeedaejj","edjd","ibciabjdefabdgbjgjhi","dhbd","bbijjcjdjjggg","feifjbj","fbdhhahfd","dg","bgeihfafeccibeccjii","gfcecgfebcbgh","jeeefihhaeccf","dgghcbiffdfafjdihai","begae","jbhjbigiceagaigad","acgfbbibihfagih","adgbgjdafcf","gadcjajadeafcabbcg","hfbdfhbcjbdd","hfejjjjbgahcheejef","eihjdcfhbgbcdgdedca","dfg","idfffagdeaee","aejgdiidhbgjaj","cchdbfdaeaaid","igjjaegfe","gedggj","jhbibhehbefddieff","ieaec","ejjifcbdjcjfejcg","djggigibjc","aie"};
		
		//String[] words = {"bbaabaaaabbbbaaaabaaaabaabbabbbaaabbabbbabbaaababbaabbaaaabbbaabbaabaaaabaaabbaabab","babbbbbaabbbaaaaaabbbbbbbaabbabbabbbbbaababaabbabbbabbbbbbabba","bbbbaabbbababbabbbbabaababaabbaabbabaaaaabababbabbabbbbbabbbbaaaabbabbabbbabababbbaaa","ababbbbbbbaaaabbaaababbbabababbaabbaababbbabbbabaabbaabaababbbabababaaabbbbabbaa","abbbaababaaaaabababaabaaaaaabbbbbbbababaaaabaabbbaaabbaaaabbbabbbbabbaaaaaaaaaaabbaaaababbabbbabbabaaaaabbaababbabbabababaaaaabbabbababbaaaabbbababaaabbaaabbabbaaba","aabbaaaaaaabaaabbbababbbbabababaaabbbabaabbababbaabbbbbaabbbbaabaa","abbabaabbaaaaaababbbabbabababbababbbbaaaaabbbaaabbaababbababbbabbaaaabbabbbabbabaaaaaaabbabbbaababaaaabbaabaabababbaaaababbabbbabaabbabbbbaaaabbabbaabbaaaababbbbbbaaaaaababba","abbabaabbabbabbbabaabbbbbabaabbbbaabaaabaabaaabbaaaaaaababbababb","bbabbbbaaabbbbaaababbabaabbbbababaaaabbaaabbbaabbbaaabaababababaaaaabbbbaaaabbbababbabbbbaabbbbaaaaaaaaaabbabaaabaabaaa","aabaabbabbabbaaabbbbbaabbaababbabbaabbabaaaaaababaabaabbaaaabbabbbaababaaabaabbbbbaabbbbabbbbaaaaabbbbabbbbabaabaabbaabbbabaabababaabbaaaaabbabaaabbaabbbabaaaababbabbbababaaabbaa","bbbaaaaaaaabaababbabbabbbb","aabbaababbbbbbbabbbababaaaababbabaaabbaaaaabbbaaababbaaabbaaaaaaabbaabbaababbbbaabbaababbabbbbbbaaabaaaabbaabaababaabaab","aabbaabaabbabaabbbababbbaababbaaaababaaaaabaaaababbabbabababaaaabbabbbabbbbbbaababaaabbbababaabaaaabbbabaaa","aabbbbbbaabbabababbbbabbbbbaabbabaabbaaabbbb","ababbabaaabaaa","babbaaaaabbaaabaaaabaabaabaaabaaaaaaabaaabba","bababaabbaaaaababbabaaabbbabababbbbbabbbbababb","aaababbbbaabaabaaaabaabbabbababaaaaab","baabbbbbaabbaaaaababbabaabbabaaaabbabbbaabbabababababbaabaaabbbaabaabbbabbaaabbbbabababaabaabaabaabbbaaabaaabbbaaabaaaabbaaabbaaaababbbbabbaabbababbaabbbbbbababaaaabbbababa","baabbabaabaababbbaababbbbbabbbabbaaaaaaaabbbaabbaabaabbbabaabaabaabbaaabaaaabaaabaababaa","bbabbbabaababaabaaabbbbaaaaaabbbaaaaaaabababababbbbababbaaaaabbaabbabababbaaaabababbababbabbababbabbaa","aabbaabaabbaaabaaaaaabaaabbabababaaaabbabaabaaabbbabababbaabaaabbabbbbabbaabbababbbabbaaaabaaababbabbbbbbaaabbaababbabaabaaabaaabbbabaababaa","babaaababaabbabbabbbbbabaaabbaaabbabaabbabbabbbaabbbaaaaaabaabbaababbbbaaababbababbabbbabaababaabbabababbbabaabbbbaabaababbaa","bbabbababaaababababaabaaaaaaaabaababaababbabbabb","bbabbbbabbaaaabaabbbbbbabbbaaaaaaabbbbabbaaabbabaabbabaabbbbbbaabbbabaaabbabaaabbaba","baabbbbbbaaaaabbaabbbbabaaabbaaaabbbaaabbabaaababaababbbbbbabbaabaaabaaabbabbabaaaba","bbbaabaabbabababbaaabbaaaababaabbbbaabaaaaaaaaabbbbaabbbbabbbabababbabbbbababbaabbba","aabbbaabaababaaaabbbbabaabaabaaabababbaabbaabbaaabaababaaabbbabaaababaabbaababbbbaababaabaabbaababbababbbbbababababaabbabbaabaaaaaabaabbaabaabaaabaabba","abbabaababbbbbbaaaaaababbaabaabbaabbaaaababaababaabbbbbaaaabbbabbbbbaabbbbbbaaababbbaabaabababb","bbbaabaabaaaaabaabaabbbbaaaabaabbbbbaabbaaabbbbbababbbbabbaaaaabbaababababababbbbbbbaaabaabbbaaaaababbbaabbabaabababbbbaaabaabbababbbaabbaabbbbaaaabababbabaabbaaaaaababaaaaabaababaabbabaabbabababab","babaabaabaabbbabaaaabaabbbaaaaaaabaababbabbbaabbbabaababbabbaabbaaabaaaabaababbabbaababbabababbbabaabbbababbbbbbbaaababbaaaabaabaabbababbaaabbaabbbaaabaabaaaabaa","abbbababaaabbaabbbbabababbaabbaaaabaabaabbbbbbbbaabbbbaaaaabbbbabaaaaabbbaaaaabbbbaaaaaababbbbbaabbabaaaaabbaabaaabaababbabaabaaabbab","babaabaababababbbbabababbbaabbaaabbbaabbaaaabaaabbbbbaaaab","aaaabbaabababbbaa","bbbbabbaabaabbbbaaaaaaaabbaababaaabaaabaaabbbbaababbbaabaabbbbaaabbabaabbbbbabbbbaaabababaabbaaababbabababbbabbabaabaaaabbab","aababaabaaaaaabbabababaaaaababbbbaabaa","bbababaaaaaaaaabaabbaaaabaaaaaaaaabbbabaabbbbbabaabaaabbbabbbabbbaaaaaabaaabbbbbbaa","abbaabaaaaabbaaaaaabbbbabaabbabbaabbbabbababaabaabaaabbababbaaabaababbbbbabbbabbabbaaaabbaababbaababbbabbbbbbaaabbbbbbb","baabababbbbbaabbbabaababaababaababbbabbbbbababbaababbaaaabaaabbbbaaaababbabbbabaabaabbababaaa","abbaabbbaabbabbabbbbbbbabbbabbaaabbaaababbaabbaababab","bbabbabbbbbbabababbbabaabbbaaaabababbaabbbabbbbaababbaabaaabbbbabaaaabbbabbaaabaabbaabbbaaababbaaaabaabbabbbabbbaaabaaabbbbabbaabbaabaa","aaaabbbabbaabbababbabbabaababbababaabbaaabaaaababbbabbaaaabbbbabaaabbbaaabababbbabbaabaaabbaabbbaabbbbaaabbbaabbbbababaaaaababbbabaabbbbbbabbabbbbbabaaabaaaaaabbaa","babaaabaabbaababaaabbaaababbbbbbbaabbbbbbbbabbaabbbbbbaaaaabbaabababaabbbabaaaaaaabbaabababaaabbabbabbaababbaaabbbaaaababbbbbabbbaabbbaaaabbabbaabbbaababbaaaabbaaaababbbbbb","abaababbaaabbbaaaaababaabbab","aabbaaaababbbabbbaaabaabababbabbbaabaaaabaabaaaabbabaabbaaabbbaaabbaabbabbbbaaabbbababbaabbaaaabbbabaabbbabbbbbbbaab","aabbbabbabaaaaabbabbababbbabbbbbbbbaabbbbabbbaabaabbaaababbbaaaaabbaaabbab","baaaabababaaababbaabbbabaaabbbbabbbbaaaabbabbbbbbbbababbaaaaabaabaaabbaabbbbbabababaabbbbaabbbbbabbaabaaabaababbbabbbabaababbaaaabbaaaaaabaababbbabaabbbaaabbbabbbaabbbbbbaabbabbbbabaabbbbaba","bbbaababaabaabbabbaabbabbaabbbbabaabbabbbbbbbabbaaaaababaaabbbaba","baaaaababaabaabaabbbbabbbbbaabbaabbaaababaabaababaabbaaabbabbbabbbaababababbaaaab","baabaaababbabbbaaaabbaabbaababbaababbbaabaabaaaaaabbbbababaaabaaabaababbaabbabbaababbbbbabbabbaabbaabbbabbbaabb","bbaaaaabbbaaabbbaaaaaaaaaabaaaaa","bbbbbbabaaaaabbbbaaabbabaababaabababbabbabaabababababbaabbabbbabbbababa","bbaabbbaabbabababaaaaaabbaabbababbbbabaabbbaabbabaabbbabbbabbaaabbabbababaaabbbababbabbbbbbbbaaaaabbaa","abaabbbaabbbbaabbabaabaaabaabaaaabbabbbabbaaabbbbababaabaaabaaaaaaaabaaaababbababaabbbbbaababaabbbbabbaaabbbabbabbbbabbbbaabaaa","bababbabbaaabbabaababbbbaabaabbbbbbababaabbbbaababababbaabbaabaaaababbabbabab","baaabbabbaaababbbbbbbaabaaabbabbaaabbabababbaaaabaabbbbaaaabbabbbbbbabaaaaabaabaaaaabababbbaabbaabbabbbbbabaababababbbbbbaabbbabbbaaabaabababaabaabbbbbbbbabaaaaabbaababab","ababababababbbabbabbbbbabbabbbbabbaaabbbbbbbbbbabbaabaabbbababbabbbaaaababbaabbbaab","baaaabbababbabaabbabbaabbbbabbbabbabbbbbabaaaabaabbbabbaababbabababaaaaabaaaababbbabbbaaaaabbbabbbaaaabbbbbaaaba","baababbbaaaabbbaaababbabaababbbbbaaabaabaaabababbbbaabbaaabaaabaaaaaabbbbbaabaaaababbbaabb","aaabaabbabaaaaaaaaaabbb","abbbaabaabbbbbabbaababbaaaaababbaaaaabbabbbb","ababaabababbbabbbbaaabbabbbaaaaaaabbabbbaba","baababbaabbbaabbbbbbaaabbbbaaaabbbbabaabbaaabaaababbbaaabbaabaabaabaaabbbbbaabaaaaab","babbabababaabbbaabababaaaaaaaaaabbbbabbababbbaaaabbaabababbbbbbbababaaaababbaaaabaabaaabaabaaaaababbbbababbaabbaaabbabaaababbbbbabbbaaabaababbaabbabbbbaaaabababaaa","abbbbbaaaaabbaabbbabaabbabaabbbaaabbaaabaabbb","abbababb","aababaaabbbabbbbaaaabaababbababbbaaaaabbababbbbaaaaaababababaabaaaabbbabbaababbbabbabaabbababbbbabbabbbabaaabababaababbbbbaaabaabaaaabbabbaaababbabaaaaa","abbbaaaaabaabbbabbbabbaaabbaababababbbaabbababaababaabbaaababbabbb","aaabaaabaabaababbabbbbaaaaaaaaabbbabbaabbababbaabababbbbbabbabababbabaaaabbbbabbbbbbbabbabaabababbaaabbaaaaaabbababbbbbbbaabbabbaaaababbabaaabbaabaaababaabaaaabaaba","baabbabbaabbbabbbbabbbaabbabaababaaaabaaaabbaaabaaababbabbbbbabaabbbaababaaababaababbaabaabaabababaaabbbbaabbbabbbbbba","abaababaaabaabbaabaaababbaabbbababbbaaaaaabbbabaaababbaabbbbaaabaabbaaabaaaababbabbbbbababbbaabbaaababaaaaaaababbbbbba","aaaabbaaaaaabbbaaaaabbaabbaabaabbababbbbbabababbababbabbaaaaabbaaabbabbaaabbbbbbaaabbbbbabbbbbabbabbaaaaaabbbbbaaaaaabbabbbbbbabbbaabbbaababbbbbabbaaabaa","ababbaaaababababbabaaabaaaaaabbbbababaababbababaabaabababaaaabbaaabaaaaaaabbbbababbabbbbabbbbbbabbbabaabbbabbbbbabbbbbababbbbaabbbaabbbababaaaabbbbaaabbab","bbabaababbabbbbbbaabbaaaabbaaabbabbaaabbabbaabaaabbbabbbababaabbbaaba","bbaaabbbaabaababbbababaaabbbbababbbbbaabaaabbbaabbbaaaaabbaabbaabaaabbabaababaaabbaababaabbbbbbaaabbabaabababaabbbaaaaabbbaaaabaabbababaaababaabbaabaaaaabaaaababbabaabababababaabaaaabaaabbaaabbbbababa","abbaaabbbaabbabb","abbbabbaaaabaabaaababaaaaabababbbaabbbbaabbbaaa","babaaabbbbbb","baaabaaabbbabaabbbaabaabbaaaabbbabbabbbbbaabbabbbabaabababaabbbbabaabaabbaaabbbabaaaaaaaaaabbbbaaabbaaaaaabaababbaabbabaabbbabaaabbbbaabbaababba","babababbbbabbaaaaaabbbbbaba","babba","abbbabaabbabbbbbbbbababaaaaaab","bbabbabbbabaaabbbaaababbbbaaaaaaabab","bbabbaabbbabaaaaaababaabbbabaaabaaababaabaaaaaaaaaaabbaababaababbababbabbababbbaaabbaaaabbaabbbbaaabbabbbabaabbbbbabababbaabaabbbabaabaaabaaababbbabbabbaababaabbbbaabaabbabbbbabbabbaababbbbba","bbaaabaaababaaaabbaabbabbbaabbaaabaababbaaababbbaaabaabaabbabababaaaabbbbbaaaabbbbbbababbbbabbbababbaababaababbbabaaabbabaaaabababaaabababaaabbbbbaaaaababaabbbbaabaaabba","ababaaaaaabbabbabba","aaabababaabaaabaaaaabaaabaababbbbbababbbabbbbbbaabbaaaaaba","baabbbab","abbaaaaababbbaaaabbbaaabbaaababbababababaabbabaabaaabaabaaabbaaabbababbaabaaaabaabababbbbbbabaabaaabaaaababbaababbaabbbbbaabbbbbbabaa","ababaaabbababbabbbaabbbaabaaaaaaaabbabaabaaaaaabaa"};
		String[] words = {"jiaeegadjjj","gcbjigjd","bjdh","gic","bifecigeggbjbfedcgc","hbbjhegaicihccaeai","gbdejaii","gddhbc","jiciiebbbagfgdi","icghahfcgjb","jdicfahacfchgacefbgb","ihi","gjgciiiejb","jaejbhghfdecje","ee","bfjiaefge","jbbcd","dhfefbcjcg","jeifidajbcidiejj","gjciddfchj","h","cdddbgjdgagbgch","hedgejadaf","jdfgdhhiajbaafdhciae","ijgjfadfciggfgfiii","jfhchd","bc","dh","ceajgccgijfaiddddghj","ccihfddjehgjchaafagj","afjidcbbihdigdghfh","hjadcega","gbbhdbihdibehfhedhba","efbfhacj","efjhjcadhdeedeahiagj","gghb","fcghiaija","ahceicffihaeg","ah","c","bcdei","hdfcgdcejb","jjhhbdhgdhggcchii","ghaiiiaid","ibb","hjdiafdjcchhihfhdd","djd","adhbdhbgha","bjafjhbib","gieid","hfcf","fdd","afcahfjehifhiabfdec","dighiif","hggfffiaaifjgjibecd","dga","hjjhfecjajaae","ciafide","djadfjfg","jedebhfiaagfbah","bcde","gdddjfdcai","bbfd","bgdeagfija","gjidc","b","jecdg","chgeafjdiafjh","abcieb","aihfifcfihc","hjjbj","cch","jgigdcjbbebifi","bfhhcbjadhcgcdgc","efee","cdfahidhacbf","ggejhd","fiihc","afhfdcjjfad","aejjgbccj","ahjjijbcgbdidfbddf","djefjdefhhgadabfc","dijebbgggbjefebfgc","cadiagee","ggfi","hchj","cfcdhjabdeigbfacfgjb","fbifeiccdaechide","djbeeeaae","gcfigaife","jgdcia","cjfjigcdhcjbhabhfaa","djcbgbc","ifbcjbifibdiacgdcii","ecj","ggddc","jcbagdfejfehicbhh","ibaffbgfbac","igeaiab","hfbjechcjcfjhcagdbg","hgafbjfihffia","cebbfcijbgcfih","bbcejdhaajcchieeje","d","iahefgcgg","ggecgebebgf","bb","acdiggbhgbhgf","gahfiejfajgdcje","fiidjicijaaae","cjegbe","aijhhfjbcfhf","gcicbjihcddijjg","fijd","acjfjfdcfcebahiafbb","fjehjibheghacbgffeg","ihcfciachhaghhe","hgigheche","gciicaeiedihejheibe","idjdhiaejciihieccj","hddhbefjejjijj","jiccfbjd","g","eibidbagaidc","jdbb","acfgbcgbhhfccfhji","jbijafbeehabde","fiecbjdiecaccbfjijhg","jdcegei","cgbfhacff","bcdddffheaejadbcdab","ddacgfdbhdcjhhahhej","cfibeeeda","cjj","eaiagcf","edfaici","hbihgbjiica","gdafbhgcjghfhediigd","fhdahdefddfccgj","fbfhiba","djdgjcfi","bhfa","bdfddfgefieff","iagfgdcjaggiacicei","bggijhege","aejadfeehhd","heggedbcddbedaibchh","ijh","egfbic","eahcbejffdhebedjfgef","gbjb","cfgge","bhcbdbg","aebibfeffcdiaidgbhbe","ajeiaabdhgegbfdfdegg","hcehbhiih","dhfchefjhjaffadcd","dfhbeejjd","bibf","gcbabcdhb","eehciafbddbhejac","hhfcfcibej","hbabbbabac","bjeagcijdbhbbiegj","jc","gjedddjejaaec","ijhbe","fcd","aaaia","accgdejhbfiecbie","dhid","ebjigebccbfdhaiigfg","icecbfcfccficdfheei","abgadgdhhaiahabdg","hbcbdfjdbjacggbi","fhcbggejgdja","dcchcahafijgdiagjh","ebjie","bfchgcdcjjidbhe","bbefigbf","je","jcfcideb","ahbdiefgjggjiicabbef","gccai","ehb","chcfbicaf","hbigifgchai","ciieife","bggiefbbea","heajfgi","aagbjad","bj","hbabi","icabcbdegaadhdaiif","db","hjjdchdcajhggcjdcbc","egbdjecehijfabjfe","fddbhgfiihdbagjfec","fgjcciciegh","iiaahijgjdeiedj","aeijeehhajibegh","gabh","dbjbacd","gcefdihibdhahbacaifb","ahhhh","dijid","hgchecii","faebcdhdbbiggdiacb","dagcbdbjabcaabeiefcf","jeb","fi","ffghjideg","eejcba","ijaacggjbecga","dcbhabidacj","eifgejacgfdccciigjcf","iafbffaejbdfeiebiej","edegfeebeafabggbib","dj","chiacgb","hcdafagfe","iijajdeghafcgdfg","fihjcgdceccb","caeagehbfjc","iiaigah","fgiiaebfa","jgjhchadbjebd","gchb","acijgi","ajjdei","bgeibfejgbejgcfjbjh","gcecceehcbadhjj","haehgb","gfefa","fdfdh","cbbjgbfjgaj","ddfafdeedj","fagbjacgajg","cddfbefjb","aiaahbfiaafeigegij","dhaieaeghggjeif","eaeegjeaggh","jgfjaiga","gadh","jhfiabfab","edjbijjeiidhddhfhcej","bieji","cggfbdb","behhaggdjbeicceedgjd","fjjccb","bhfabbdghfhhegiaigj","egefhif","gjffaejhigfgjiaaaj","hg","bdgcgefcdg","jgdiiiidaed","jafeebjibjeefeicd","djdfadjfgbdce","ibh","ijjdeb","gidghhebejcfhacig","edbdiagedejgacicaac","ghibbgagjjdgeieb","bcihgajjg","ffbjbgieejegfgaa","gfgfbffegbdeib","hiefhicjabjdfbhgaha","ci","dhee","bfehhaacaggefee","j","hiiec","egibffhi","efgbbbbecjeficjcjf","daidjfc","igacchhedbgihiaadgja","eciacijjhcjcefeebdgf","bjhgcdcaba","dbdahfdiifhfia","ifchajcjfeaabdi","fjcccejhjigefjfi","bjhdgfjfe","bidedgfijgabfjb","cifbjac","gfjddbifdgjcaihafdgj","bjhfajadibbhcd","jga","hae","ijdeaijbbihhdgcg","jjfhhecefjajgdigedb","hidihhjc","idcgdh","cihag","hhghhcbh","baffic","i","jbadhd","jbjcc","eifdgjefacjhheejheb","bdhaffhdaj","hjccbgibdhhfbb","aaejedjiagajbf","adcfhjefc","iececcjf","dbdjjfgfccaffcb","cjdcbichg","ecgc","ff","fjbediidfcjhebac","jfdgdhgc","iehgjjhfacfb","jdjhbgaefcad","fhdacjijfagfi","dfgeddhificfdcacag","jaedecbhfeijic","egjhfehjdghdchgg","aeb","bhf","gf","bgjjjdddabcjfebbcg","bejfjiebgbhefdhehfeg","icjfecjfhecddc","fcddcdieicicee","heibificfejdji","a","ehejbjdbjbccaiagcgc","ghfbajcdjhgaaedjfh","hbbfehhbbjjghfgehib","gffhahdd","ibcbejgidajjegb","ajfbdgaaige","ahhh","ehcjheda","ccjjjbegdi","ch","ejjgaggbegjg","bjf","fecahi","dhjbebbgeagdf","hgggigaehdbcjjaj","chha","chhcajhgbbbcabjgjg","bbajibcfb","chdaafehiiaaegefjhbe","iihdacbdja","caaafjccejfcbfhjeej","hbdab","cdhfdjhhdgcj","ecdgigcjfdbfaejadhdb","fcihafigiagcefhi","bbefjejajjbifadaha","eabeiafcjfbcjagbe","jf","hibhgdecdbdcahfjjc","ciffddibfjchhgbajc","dgaabjbhf","iiebeih","becbihjecjfaic","dghjfjbeejigaadefbh","edhf","jhedhhacfgecea","iee","gbdga","dhiabdgaficj","ifiegifjcjie","dhahgb","gffdj","gc","ejcggdfiahedcfg","gdjgdifabgfc","dbbdgfeffajhfheja","ecbffdiaejbadiigbiaj","gaaafdh","cdacadbdbfbi","bddbj","fcefecjahfchhei","ibacebfj","dcfafhbabggfagiddga","fhhihaabaegeicg","bfab","bdf","jaf","bicegfgadbfjdagfj","icg","djbieabjeice","hjggfggjeghahebdb","ejfbjaeidejgidjf","iahgfidegihfeiaaaec","afeidjijciib","cdjedcagihdehcfihge","gbhacbicfihchj","jcfhbhdghbfcfjgb","gbijiabbahbgechb","bhjbchjgcagebdj","hhedbecgg","fjhgjeajeghifgh","fgggbdbbehhiiabia","hjjfb","bgahgadbgfebgj","bjajcf","jh","jccfedggjcaiehga","aejjdfdebebifdeedj","idiceeicbbd","gdffgdjdbeedcbd","bbbfcejdbjefbbg","adghdcafgfdhadggca","bbcifd","jiagdejdjhicgfhdifa","fdcfjedegdcdjcgafgc","abdhjbdjfg","dacijecjieddfefj","hhcahheecah","ddecafhdjahgeiafbf","fibehccedjhfj","fegj","fcad","faadfdcgjgadhajf","ccdjbabdgffhdhfbjdji","ihichbheffgfiabacdbf","fjiffecfhf","jdechcfdeffiaafcce","fbiigehdcgfgbbdhcidi","dghbdgcf","ifjffdjjafciidfadccf","dagegjdagfgdgag","beadcfec","fififgagefiejggfhbgh","idfahggfhbedechgdj","gbegaaide","ecc","jfjcehgc","gbfe","ffih","fajijcii","gajc","gccegfibh","ijiheifich","ijbcbbcjddcigai","hfdifcbgicjahjjgh","dajceihgaiahi","eh","bebjcdgcccdigigagj","cijagihahaj","dcbfdhjhhcgge","eega","fbbfgdcaiajf","hadcjhjdfcjg","egjfagfdcceai","hc","dabgddegghd","ebf","dfed","ife","agiiggbdjdjfdcfdgh","bgfghj","ddcibhbeejgciec","bagjeijihhjcicjhbe","aaciedgfegibbjhaciaj","ebchiacai","dgfaaficcaiijfgha","bjgfhfciegifj","jigfchcghi","e","dc","fdjbefhacbgggeaide","daabjbbcjbgc","dfa","fejicdhecicjjigdffi","edddd","cdchcedcebc","df","abfihihee","cjidhaf","igaahfhcjccg","bhjifcdajaahefgf","hhccdjddjehfhicbbj","eagadaabjhfgbighjah","cbdigdhafae","ifhb","bjfhiifaebadadidjhji","jdhi","dehgdadejhdbcefc","ccjcjjhh","eahgbig","fbbggibcaidfjgbjijf","hicaajigfed","hchfcbjfah","gdjie","cbedjachjdjegficc","fdedihdg","ddaddjcagbg","iefh","aadbibjcebbgcg","gafedcgegg","afjbiefajj","jhcjgbiiiaeaj","ie","iajjggfehcifejfbhbg","eejhaici","fdedghjaacdbgcbjacc","idb","hfjcaejhgighcfaejba","giehbfgiihe","edccfjjccfcefhijib","ijiddhjdj","ecaiddaieffd","iefabfbebjcfgibc","efccjcchehggbaihe","bia","fheiaijb","de","ibjafee","bdbdgg","ccifbdeagcjfegagcabc","jhacahdjec","bej","hfhiehajbf","jahdafec","ichcihgigh","fggiddhajigcbdijeh","bcei","fdjbbifhfbg","ad","fijbfgdjejace","hgjaiehcf","gdgfghbdeah","caa","ahebic","djihicijdjjjgg","agbdcebgeieidjec","jbfhieajhb","chafahbdeeiaibcja","ajjdc","dfhbadg","aeebfaeeefddfgdaf","dcgcfhf","cjejfeeh","gahedajgig","bhhejecdebfg","hacifcejegggiiebg","ifceefab","cd","ehcffaecejdjbhffa","becedcchi","ibffji","jhcgac","igggeaji","jehgeeadbiebaaejgaj","jeaehdchfehiceheid","bda","edfhjfahiaaihfegfieg","bbjdbfhebbbifcgebdb","bifcfjjc","djbfaebcedc","icdigh","accegabafaj","cbfaahefhdgdciedijc","idh","gdaajj","jiiecjj","ggiaehfgcgjdjga","jgbi","aefbecaj","bgahfbbhdced","ed","gfaaad","dihjhcfaaehcjjdbaja","hhcjaihgejjbahh","bceadgdajiih","dfigjjgbghh","aededfi","gijeg","ifiijidcgbgefihd","higbedifdjiedfbcbi","idhfae","eje","bhc","icgebbhhbjcb","fheaighea","ffdggighhc","cgbjaibcfhijgahhbf","bdbeebadegifbdgab","dcc","iae","gfhcdhdffjidabjc","bicfeideiai","jaedi","iah","fgagidafcejhd","cgedeeiaehjfdfe","jcjjddcbjhbj","dbgfbidhgjhiaj","igcfjhegbceja","ideebhaafidghhib","deaiccfcdgciic","gebcf","gj","gjhcdfchaachfiei","bhccfahgaedda","debiae","dfechabeheaggigih","f","ecffhgabdafiggjgab","aj","ciefdijbaahjbdb","iaabi","jgdahjjdbb","fihaeggjhg","hcbfhgbagjcfiadfbef","fbjbbijbj","ebefdgfaedeieaddje","jgifd","aghidfffaafaebfibdhi","gdicieeejad","fd","aijfgjeeafjdebf","fhge","jejdgjjeejef","gchhiccbi","bhddeih","efdajjcgdcaihhgfag","eaefjihfejgi","jcfbidcfgfecaff","faie","gdfcjfibccggch","chafficjgjhfcbhbbfh","fiiiaac","fdiaacagfghdgcjhbf","edgeheaajicf","ef","bgjbeiajaea","jbfgahhjajehhcbifje","hjjejbccjccdjdh","ajchedfifbebfihj","bijjfahfefcbghejbjch","jiaigjaidfacjhhjdd","jifbecchifcbj","hccifhhifaffbeegjjh","cihghbjhjbjeahjahdc","efjfieiifgghj","jahagfcghgf","ha","jaefcheabcfjc","jibhjfiaca","gijgihea","hdecejabjgdc","bdcfjh","geaa","cabiabhbbgfbf","caahedgiaicdecijc","hjgehghjfgdafhbgdfa","ejibjhefaeah","jghhebgbhje","fhigghbhcicg","dfeigbjidie","efbjjibhbaehjafa","jgjcaidfbehh","ebbfg","ehgbbfecidbbfbdi","ijjhbidddagijdgbaic","fbhfghfchbeahabjbece","jdbbhcifiaead","jhdicja","icbcciiabcchcii","ijiiaeaddbah","bfbefejhfegfegdgdg","jcdgggefiffgijafdab","cididajibfagehce","cdfdfjdfebjjeaeecie","hciih","hjbehh","fihgefcaefcagbdjfbif","gbficdhbajghc","fgigd","cibaiacbgfia","ghdifgjjfjeid","cci","eacdbj","dgg","cdg","icchjh","ceahbebaefbdj","aafaddigajhghgi","jhijggaggdgdgdghjhj","cccje","dhabjfhcjajgdgijhcbc","affahfihcbfhafieaec","cjgbegjbgih","faahdccfheabha","aibdaccaadbje","dggafifefhchjfggig","djdecefgbgfiadij","eja","aichhhhbcedj","ghdjieaeejehgdigdagf","cbaeehgfhhjiicfd","cigccfebdggadg","jcjddf","ieajchic","ddb","chgbjdbiebbdcffi","begjceg","bdebjjje","idijjgc","hihhidhacigiah","fahfifiaaigiegea","eeeccd","ifbhagaaaiijjj","ebhgbaighidijiidi","fcgedhhcdccj","jdjhefbac","abf","bejdejhafadcgeijahg","hgbicbidhjbdajajhbi","fiecc","heiiiah","ghffbbaegfhjegi","hfdbibfiijcida","cegjajgajiai","dbfcacceidcbgjjbgba","jagcdhhddbhgca","ebfjjbfb","dchbaahebcabbjfi","hcdfbf","degiaefhcigijdehef","gjecdhced","dficefbihdeg","jchg","jbjdcfffcjifafbiihfc","dighhdgjajgieiidbee","bgfabfhecaf","bfgi","hjcfjbjdehfdehdfgdjb","jdgcdccbdbedfdea","giaahgah","bgiihfebfj","hibcdfiadchajeef","ieghhdddcjdbia","jijhcggdjebgd","fgc","jjfdidjhh","afjchifcacdaihijh","acfebiaace","jggjiddaabaagef","dgiafgeceidabjif","agja","gfdhc","egejehijbhfchhhjce","ajgdcbehbcjdjaafjbaj","jjacdee","jia","dggihjbibcgbgadje","aegghhdfgcbfhj","ffab","dchghddagjfaagieachf","bebbeccbbjeebaf","fjbaj","dajehgf","iiiaeihbjihiaeidebic","efccihh","eeeiafbbjifae","abighbcdbibfbjgji","fid","gbdhgidefdcihf","dhghdigfhcacebfcf","jbdcgabeecgiiceachg","jbacfh","ffdbecidc","egfecfga","dd","dgcjibjbhgh","jjaebhfbffi","efiiehffafeagaigg","daigbbifajdid","baebciediadd","bdjgahgfghedb","bbgjgjdb","cahdeeaga","hjgadjfe","gbdiighebcdiggaij","dejgjbjdehgfbgj","ebceg","hjedcbihd","ebfegbfaccbhegabfbh","eehecef","bfhbfhfifdcgajac","jcfebffcjaj","hiecjje","ijdbdbgiabgfhaf","hjfhgajdji","igjaibddgdihbbjbgcff","djhc","dcjdaaagfgfjddjj","chhjdgafc","gjbdchfbbfeaf","degffdei","eeacbfcjggg","faehjfidf","iejaiiggfigegibjhdf","ighebfgccdacgjej","idgifjcaf","feej","jegjbbafbga","hbhciddjjfif","fbhdaigigjbc","ggje","fiahggjfded","bjeegechjjegifif","dhaaid","bgi","dchcaigdfijeb","gabifdaba","adchid","ddiahjahaiged","gjicaejjehcaafb","fj","ceijdgcjai","jihaajfcgdcacdbaidgh","gcecihjbbbjfeeed","gebcciagjaecfdjg","cbjh","hffedcigehfejgcd","dcjbgdf","gicjajgafiafcbfdggf","ihhdbacefbg","bccaa","iiigijj","jicbaji","bbdcgihebii"};
		
		//String[] words = {"abcd","dcba","lls","s","sssll"};
		//String[] words = {"lls","s","sssll"};
		long startTime = System.currentTimeMillis();
		
		System.out.println(palindromePairs(words));
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		//Stopwatch timer = new Stopwatch().start();
		System.out.println(elapsedTime);
		
		
		
		//
	
	}
}
