-- phpMyAdmin SQL Dump
-- version 4.7.3
-- https://www.phpmyadmin.net/
--
-- Hôte : fredericisroot.mysql.db
-- Généré le :  Dim 03 fév. 2019 à 22:46
-- Version du serveur :  5.5.60-0+deb7u1-log
-- Version de PHP :  5.6.38-0+deb8u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `fredericisroot`
--

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `IDutilisateur` int(11) NOT NULL,
  `MDP` varchar(50) COLLATE utf8_bin NOT NULL,
  `Mail` varchar(100) COLLATE utf8_bin NOT NULL,
  `Nom` varchar(100) COLLATE utf8_bin NOT NULL,
  `Prenom` varchar(100) COLLATE utf8_bin NOT NULL,
  `Admin` tinyint(1) NOT NULL DEFAULT '0',
  `image` varchar(150) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`IDutilisateur`, `MDP`, `Mail`, `Nom`, `Prenom`, `Admin`, `image`) VALUES
(2, 'b8d511e4973108b17d280f0aaf2f0b4c4f932087', 'fredericpinaud@epsi.fr', 'Pinaud', 'Frederic', 1, 'img/fred.jpg'),
(4, '8a23864b37c81faf212034bdbba4a4d28821b014', 'aureliebuillet@epsi.fr', 'Buillet', 'Aurélie', 1, 'img/aurelie.jpg');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`IDutilisateur`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `IDutilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
