def empirischerMittelwert(varFloat)
    temp = varFloat.reduce(0) {|x,sum| sum+=x}
    temp/varFloat.length
end

def empirischeVarianz(varFloat)
    vorne = 1.0/(varFloat.length-1)
    innen = 0.0
    varFloat.map {|x| innen += x**2}
    hinten = varFloat.length * empirischerMittelwert(varFloat)**2
    vorne*(innen-hinten)
end

def empirischeKovarianz(varFloatX, varFloatY)
    vorne = 1.0/(varFloatX.length-1)
    innen = 0.0
    varFloatX.each_with_index {|x,i| innen+= x*varFloatY[i] }
    hinten = varFloatX.length * empirischerMittelwert(varFloatX)*empirischerMittelwert(varFloatY)
    vorne*(innen-hinten)
end

def empirischeKorrelationskoeffizient(varFloatX, varFloatY)
    unten = Math.sqrt(empirischeVarianz(varFloatX) * empirischeVarianz(varFloatY))
    empirischeKovarianz(varFloatX, varFloatY) / unten
end

def lineareRegression(varFloatX, varFloatY)
    a = empirischeKovarianz(varFloatX, varFloatY) / empirischeVarianz(varFloatX)
    b =  empirischerMittelwert(varFloatY) - a* empirischerMittelwert(varFloatX)
    y = "y=#{a}x+#{b}"
end


print "Zahlen eingeben X: "
varX = gets.chomp.split
#varX = "56 70 62 71 81 58 60 79 73 61".split
varFloatX =[] 
varX.each {|x| varFloatX << x.gsub(",",".").to_f}
print "Zahlen eingeben Y: "
varY = gets.chomp.split
#varY = "165 175 167 175 180 166 169 180 176 168".split
varFloatY =[] 
varY.each {|x| varFloatY << x.gsub(",",".").to_f}

puts "Empirischer Miteelwert X: #{empirischerMittelwert(varFloatX)}"
puts "empirischeVarianz X: #{empirischeVarianz(varFloatX)}"
puts "Empirischer Miteelwert Y: #{empirischerMittelwert(varFloatY)}"
puts "empirischeVarianz Y: #{empirischeVarianz(varFloatY)}"
puts "empirischeKovarianz XY: #{empirischeKovarianz(varFloatX, varFloatY)}"
puts "empirischeKorrelationskoeffizient XY: #{empirischeKorrelationskoeffizient(varFloatX, varFloatY)}"
puts "lineareRegression XY: #{lineareRegression(varFloatX, varFloatY)}"

