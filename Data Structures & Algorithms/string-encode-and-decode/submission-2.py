class Solution:

    def encode(self, strs: List[str]) -> str:
        if strs == []:
            return "specialcase"
        return("€".join(strs))


    def decode(self, s: str) -> List[str]:
        if s == "specialcase":
            return []
        words = s.split("€")
        return words
